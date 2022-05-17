package com.example.appcube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextView txtvRestContra;
    TextView txtvInscribirseLogin;
    EditText editTxtNombreLogin, editTxtContraLogin;
    Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtvRestContra = (TextView) findViewById(R.id.txtvRestContra);
        txtvInscribirseLogin = (TextView) findViewById(R.id.txtvInscribirseLogin);

        editTxtNombreLogin = (EditText) findViewById(R.id.editTxtNombreLogin);
        editTxtContraLogin = (EditText) findViewById(R.id.editTxtContraLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);

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

    public void irRestablecer(View view) {
        Intent rest = new Intent(this, RestablecerActivity.class);
        startActivity(rest);
    }

    public void irInscribirse(View view) {
        Intent insc = new Intent(this, InscribirseActivity.class);
        startActivity(insc);
    }

    public void irHome(View view) {
        Intent home = new Intent(this, HomeActivity.class);
        startActivity(home);
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
                        //Intent perfil = new Intent(getApplicationContext(), PerfilFragment.class);
                        //perfil.putExtra("correo", inputCorreo);
                        startActivity(inicio);
                    } else {
                        Toast.makeText(getApplicationContext(), "ERROR EN EL LOGIN", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}