package com.example.appcube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InscribirseActivity extends AppCompatActivity {

    TextView txtvRegistrarseInsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscribirse);

        txtvRegistrarseInsc = (TextView) findViewById(R.id.txtvRegistrarseInsc);

        txtvRegistrarseInsc.setOnClickListener(new View.OnClickListener() {
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
}