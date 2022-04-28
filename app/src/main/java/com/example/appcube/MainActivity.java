package com.example.appcube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Button btnEmpezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpezar = (Button) findViewById(R.id.btnEmpezar);

        int imagenes[] = {R.drawable.uno, R.drawable.dos, R.drawable.tres};
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        for (int i = 0; i < imagenes.length; i++) {
            flipperImagenes(imagenes[i]);
        }
    }

    public void flipperImagenes(int imagen) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(imagen);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
    }

    public void irLogin(View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }
}