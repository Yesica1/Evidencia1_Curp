package com.example.dell.ev1_curp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity_Splash extends AppCompatActivity {

    /**Duracion estiamada de la imagen establecida en el Splash**/
    private final int DURACION_SPLASH = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__splash);

        setContentView(R.layout.activity__splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (Activity_Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        },DURACION_SPLASH);


    }
}
