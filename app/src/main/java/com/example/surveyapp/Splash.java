package com.example.surveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.surveyapp.Base.BaseActivity;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(activity , HomeActivity.class));
                        finish();
                    }
                },3000);

    }

}
