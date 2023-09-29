package com.example.android_studio_project;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("182,LifeCycle", "OnStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("182,Lifecyle", "OnResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("182,Lifecyle", "OnPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("182,Lifecyle", "onStop invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("182,Lifecyle", "onDestroy invoked");
    }
}