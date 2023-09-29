package com.example.android_studio_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitIntentDestination extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_destination);
        TextView showname = (TextView) findViewById(R.id.textView);
        String name = getIntent().getStringExtra("name");
        showname.setText(name);
    }
}