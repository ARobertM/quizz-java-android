package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class QuizzActivityMain extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        withoutBar();
        setContentView(R.layout.activity_quizz_acivity_main);
        configNavigation();
        initComponents();
        }


    private void withoutBar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    private void initComponents() {
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(getItemSelected());
    }

    private NavigationView.OnNavigationItemSelectedListener getItemSelected() {
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.geography_nav){
                    Toast.makeText(getApplicationContext(),
                                    R.string.quizz_1_selected,
                                    Toast.LENGTH_SHORT)
                            .show();
                    Intent intent1 = new Intent(QuizzActivityMain.this, Quizz1_Geography.class );
                    startActivity(intent1);
                }
                if(item.getItemId() == R.id.sciene_nav){
                    Toast.makeText(getApplicationContext(),
                                    R.string.quizz_2_selected,
                                    Toast.LENGTH_SHORT)
                            .show();
                    Intent intent2 = new Intent(QuizzActivityMain.this, Quizz2_Science.class );
                    startActivity(intent2);
                }
                if(item.getItemId() == R.id.art_nav) {
                    Toast.makeText(getApplicationContext(),
                                    R.string.quizz_3_selected,
                                    Toast.LENGTH_SHORT)
                            .show();
                    Intent intent3 = new Intent(QuizzActivityMain.this, Quizz3_Art.class );
                    startActivity(intent3);

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        };
    };

    private void configNavigation() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_navigation_drawer,
                R.string.close_navigation_drawer
                );
                toggle.syncState();
    };



}




















