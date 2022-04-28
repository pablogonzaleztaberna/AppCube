package com.example.appcube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RestablecerActivity extends AppCompatActivity {

    TextView txtvRegistrarseRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer);

        txtvRegistrarseRest = (TextView) findViewById(R.id.txtvRegistrarseRest);

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
}