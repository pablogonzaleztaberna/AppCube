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

public class InscribirseActivity extends AppCompatActivity {

    EditText editTxtNombreInsc, editTxtContraInsc1, editTxtContraInsc2;
    Button btnRegistrarseInsc;
    TextView txtvRegistrarseInsc;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscribirse);

        editTxtNombreInsc = (EditText) findViewById(R.id.editTxtNombreInsc);
        editTxtContraInsc1 = (EditText) findViewById(R.id.editTxtContraInsc1);
        editTxtContraInsc2 = (EditText) findViewById(R.id.editTxtContraInsc2);
        btnRegistrarseInsc = (Button) findViewById(R.id.btnRegistrarseInsc);
        txtvRegistrarseInsc = (TextView) findViewById(R.id.txtvRegistrarseInsc);
        mAuth = FirebaseAuth.getInstance();

        btnRegistrarseInsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUser();
            }
        });

        txtvRegistrarseInsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irLogin(v);
            }
        });
    }

    public void registrarUser() {
        String inputNombre = editTxtNombreInsc.getText().toString();
        String inputContra1 = editTxtContraInsc1.getText().toString();
        String inputContra2 = editTxtContraInsc2.getText().toString();

        if (inputNombre.isEmpty()) {
            Toast.makeText(this, "INGRESA NOMBRE USUARIO", Toast.LENGTH_SHORT).show();
        }
        else if (inputContra1.isEmpty()) {
            Toast.makeText(this, "INGRESA CONTRASEÑA", Toast.LENGTH_SHORT).show();
        }
        else if (inputContra2.isEmpty()) {
            Toast.makeText(this, "INGRESA CONTRASEÑA", Toast.LENGTH_SHORT).show();
        }
        else if (!inputContra2.equals(inputContra1)) {
            Toast.makeText(this, "LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.createUserWithEmailAndPassword(inputNombre, inputContra1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "REGISTRO CON ÉXITO!", Toast.LENGTH_LONG).show();
                        mAuth.signInWithEmailAndPassword(inputNombre, inputContra1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "LOGIN CON ÉXITO!", Toast.LENGTH_LONG).show();

                                    Intent inicio = new Intent(getApplicationContext(), HomeActivity.class);
                                    startActivity(inicio);
                                } else {
                                    Toast.makeText(getApplicationContext(), "ERROR EN EL LOGIN", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "ERROR EN EL REGISTR0", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public void irLogin(View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }
}