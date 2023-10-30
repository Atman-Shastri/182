package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class shared_preferences extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        editText = findViewById(R.id.editTextText);
    }

    public void save(View view) {
     String message = editText.getText().toString();
     SharedPreferences preference = getSharedPreferences("myFile",MODE_PRIVATE);
     SharedPreferences.Editor e =  preference.edit();

     e.putString("key1", message);
     e.commit();

     editText.setText("");

        Toast.makeText(this, "Saved data to shared preferences", Toast.LENGTH_LONG).show();

    }

    public void load(View view) {
        SharedPreferences preference = getSharedPreferences("myFile",MODE_PRIVATE);

        String message = preference.getString("key1","Key does not match");

        editText.setText(message);

        Toast.makeText(this, "Loaded data from Shared Preferences", Toast.LENGTH_LONG).show();
    }
}