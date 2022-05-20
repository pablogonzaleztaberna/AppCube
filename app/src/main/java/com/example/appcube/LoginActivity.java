package com.example.appcube;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {

    TextView txtvRestContra;
    TextView txtvInscribirseLogin;
    EditText editTxtNombreLogin, editTxtContraLogin;
    Button btnLogin, btnGoogle;
    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 100;
    private GoogleSignInClient googleSignInClient;
    String TAG = "GoogleSignInLoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut();
                googleSignInClient.getSignInIntent();
            }
        });*/

        txtvRestContra = (TextView) findViewById(R.id.txtvRestContra);
        txtvInscribirseLogin = (TextView) findViewById(R.id.txtvInscribirseLogin);

        editTxtNombreLogin = (EditText) findViewById(R.id.editTxtNombreLogin);
        editTxtContraLogin = (EditText) findViewById(R.id.editTxtContraLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnGoogle = (Button) findViewById(R.id.btnGoogle);

        mAuth = FirebaseAuth.getInstance();

        txtvRestContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRestablecer(v);
            }
        });
        txtvInscribirseLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irInscribirse(v);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            if (task.isSuccessful()) {
                try {
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                    firebaseAuthWithGoogle(account.getIdToken());
                }
                catch (ApiException e) {
                    Log.w(TAG, "Google sign in failed", e);
                }
            }
            else {
                Log.d(TAG, "Error en el login: " + task.getException().toString());
                Toast.makeText(this, "Ocurrió un error: " + task.getException().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "signInWithCredential:success");

                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                    LoginActivity.this.finish();
                }
                else {
                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                }
            }
        });
    }

    public void irRestablecer(View view) {
        Intent rest = new Intent(this, RestablecerActivity.class);
        startActivity(rest);
    }

    public void irInscribirse(View view) {
        Intent insc = new Intent(this, InscribirseActivity.class);
        startActivity(insc);
    }


    public void loginUser() {
        String inputCorreo = editTxtNombreLogin.getText().toString();
        String inputContra = editTxtContraLogin.getText().toString();

        if (inputCorreo.isEmpty()) {
            Toast.makeText(this, "INGRESA CORREO", Toast.LENGTH_SHORT).show();
        } else if (inputContra.isEmpty()) {
            Toast.makeText(this, "INGRESA CONTRASEÑA", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.signInWithEmailAndPassword(inputCorreo, inputContra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "LOGIN CON ÉXITO!", Toast.LENGTH_LONG).show();

                        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferencias.edit();
                        editor.putString("correo", inputCorreo);
                        editor.putString("contra", inputContra);
                        editor.commit();

                        Intent inicio = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(inicio);
                    } else {
                        Toast.makeText(getApplicationContext(), "ERROR EN EL LOGIN", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}