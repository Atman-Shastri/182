package com.example.android_studio_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToastMessage extends AppCompatActivity {
    private EditText editTextNumber1, editTextNumber2;
    private Button buttonAdd;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_message);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonAdd = findViewById(R.id.buttonAdd);
        textViewResult = findViewById(R.id.textViewResult);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number1 = Double.parseDouble(editTextNumber1.getText().toString());
                    double number2 = Double.parseDouble(editTextNumber2.getText().toString());
                    double result = number1 + number2;
                    String resultText = "Result: " + result;
                    textViewResult.setText(resultText);
                    // Display the result in a Toast message
                    Toast.makeText(ToastMessage.this, resultText, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(ToastMessage.this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}