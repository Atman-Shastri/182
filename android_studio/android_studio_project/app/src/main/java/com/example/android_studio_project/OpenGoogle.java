package com.example.android_studio_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class OpenGoogle extends AppCompatActivity {
    String googleUrl = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_google);
    }

    public void openGoogle(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleUrl));
        startActivity(intent);
    }
}