package com.luisamoncada.miapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class Asplash extends AppCompatActivity {

    // Duración en milisegundos que se mostrará el splash
    private static final long SPLASH_SCREEN_DELAY= 10000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_asplash);

        TimerTask task = new TimerTask(){

            public void run (){
                Intent mainIntent = new Intent().setClass(
                        Asplash.this,MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task,SPLASH_SCREEN_DELAY);

        }
    }
