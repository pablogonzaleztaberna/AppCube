package com.example.appcube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    Button btnEmpezar;

    ImageView imgv1;
    ImageView imgv2;
    ImageView imgv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);

        btnEmpezar = (Button) findViewById(R.id.btnEmpezar);

        imgv1 = findViewById(R.id.iv1);
        imgv2 = findViewById(R.id.iv2);
        imgv3 = findViewById(R.id.iv3);

        int imagenes[] = {R.drawable.uno, R.drawable.dos, R.drawable.tres};

        ViewPagerAdapter adapter = new ViewPagerAdapter(imagenes);
        viewPager2.setAdapter(adapter);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                changeColor();
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                changeColor();
            }

        });

    }

    void changeColor() {
        if (viewPager2.getCurrentItem() == 0) {
            imgv1.setBackgroundResource(R.color.active);
            imgv2.setBackgroundResource(R.color.grey);
            imgv3.setBackgroundResource(R.color.grey);
            btnEmpezar.setText("Siguiente");
        }
        else if (viewPager2.getCurrentItem() == 1) {
            imgv1.setBackgroundResource(R.color.grey);
            imgv2.setBackgroundResource(R.color.active);
            imgv3.setBackgroundResource(R.color.grey);
            btnEmpezar.setText("Siguiente");
        }
        else if (viewPager2.getCurrentItem() == 2) {
            imgv1.setBackgroundResource(R.color.grey);
            imgv2.setBackgroundResource(R.color.grey);
            imgv3.setBackgroundResource(R.color.active);
            btnEmpezar.setText("Empezar");
        }
    }



    public void irLogin(View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }
}