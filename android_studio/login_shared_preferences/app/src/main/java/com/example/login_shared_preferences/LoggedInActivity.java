package com.example.login_shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoggedInActivity extends AppCompatActivity {

    SharedPreferences preference;
    TextView details_field;
    Button logout_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        details_field = findViewById(R.id.details_field);
        logout_button = findViewById(R.id.logout_button);
        preference = getSharedPreferences("user_details",MODE_PRIVATE);

        String username = preference.getString("user_name","Could not find username");
        String password = preference.getString("password","Could not find password");

        details_field.setText("Hello, " + username);



    }

    public void logout(View view) {
    Intent intent = new Intent(LoggedInActivity.this, HomeActivity.class);

    SharedPreferences.Editor editor = preference.edit();

    editor.clear();
    editor.commit();

    startActivity(intent);

    }
}