package com.example.quizzapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

//  Variabile
    Animation topAnimation, bottomAnimation;
    ImageView logo;
    private AppCompatButton btnStart;
    private ActivityResultLauncher<Intent> launcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        withoutBar();
        initComponent();
        animateLogo();


    }

    private void withoutBar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    private void animateLogo() {
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        logo = findViewById(R.id.iv_main_logo);
        logo.setAnimation(topAnimation);
        logo.setAnimation(bottomAnimation);
    }

    private void initComponent() {
        btnStart = findViewById(R.id.btn_start_main);
        btnStart.setOnClickListener((getAddListener()));
    }

    private View.OnClickListener getAddListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent( MainActivity.this, QuizzActivityMain.class);
                startActivity(intent);

            }
        };
    }

}