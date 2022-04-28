package com.example.appcube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView txtvRestContra;
    TextView txtvInscribirseLogin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtvRestContra = (TextView) findViewById(R.id.txtvRestContra);
        txtvInscribirseLogin = (TextView) findViewById(R.id.txtvInscribirseLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);

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
            public void onClick(View v) {
                irHome(v);
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
}