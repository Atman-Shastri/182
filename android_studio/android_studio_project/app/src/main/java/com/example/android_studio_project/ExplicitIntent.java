package com.example.android_studio_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
    }

    public void Show(View view) {
        EditText name = (EditText) findViewById(R.id.editTextText);
        Intent i = new Intent(ExplicitIntent.this, ExplicitIntentDestination.class);
        i.putExtra("name", name.getText().toString());
        startActivity(i);
    }
}