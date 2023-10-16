package com.example.login_shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText username_field;
    EditText password_field;

    Intent intent;
    Button login_button;
    SharedPreferences preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username_field = findViewById(R.id.username);
        password_field = findViewById(R.id.password);
        login_button = findViewById(R.id.login_button);

        preference = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(HomeActivity.this,LoggedInActivity.class);

        if(preference.contains("user_name") && preference.contains("password")){
            startActivity(intent);
        }


    }
    public void login(View view) {
        String user_name =  username_field.getText().toString();
        String password =  password_field.getText().toString();

        if(user_name.equals("abc") && password.equals("123")){
            SharedPreferences.Editor editor = preference.edit();

            editor.putString("user_name",user_name);
            editor.putString("password",password);
            editor.commit();
            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Failed Login, wrong credentials",Toast.LENGTH_SHORT).show();
        }

    }
}