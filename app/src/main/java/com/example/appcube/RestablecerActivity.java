package com.example.appcube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class RestablecerActivity extends AppCompatActivity {

    EditText editTxtNombreRest;
    Button btnRegistrarseRest;
    String inputNombre;
    TextView txtvRegistrarseRest;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer);

        editTxtNombreRest = (EditText) findViewById(R.id.editTxtNombreRest);
        btnRegistrarseRest = (Button) findViewById(R.id.btnRegistrarseRest);
        txtvRegistrarseRest = (TextView) findViewById(R.id.txtvRegistrarseRest);
        mAuth = FirebaseAuth.getInstance();

        recuperarContra();

        txtvRegistrarseRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irLogin(v);
            }
        });
    }

    public void irLogin(View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    private void recuperarContra() {
        btnRegistrarseRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNombre = editTxtNombreRest.getText().toString();

                if (!inputNombre.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enviando correo... Espere.", Toast.LENGTH_LONG).show();
                    enviarCorreo();
                }
                else {
                    Toast.makeText(getApplicationContext(), "ERROR AL RECUPERAR CONTRASEÑA", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void enviarCorreo(){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(inputNombre).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Le hemos enviado un correo para recuperar su contraseña", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "No se pudo enviar el correo", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}