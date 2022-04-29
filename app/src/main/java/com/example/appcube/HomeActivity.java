package com.example.appcube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    CuentosFragment cuentosFragment = new CuentosFragment();
    BuscarFragment buscarFragment = new BuscarFragment();
    PerfilFragment perfilFragment = new PerfilFragment();
    ChatFragment chatFragment = new ChatFragment();
    AjustesFragment ajustesFragment = new AjustesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setSelectedItemId(R.id.nav_mas);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,cuentosFragment).commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_buscar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,buscarFragment).commit();
                        return true;
                    case R.id.nav_perfil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,perfilFragment).commit();
                        return true;
                    case R.id.nav_mas:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,cuentosFragment).commit();
                        return true;
                    case R.id.nav_chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,chatFragment).commit();
                        return true;
                    case R.id.nav_ajustes:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,ajustesFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}