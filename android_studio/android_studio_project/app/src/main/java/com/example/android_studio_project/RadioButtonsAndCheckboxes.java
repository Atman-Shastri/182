package com.example.android_studio_project;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RadioButtonsAndCheckboxes extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioOption1, radioOption2;
    private CheckBox checkOption1, checkOption2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_buttons_and_checkboxes);

        radioGroup = findViewById(R.id.radioGroup);
        radioOption1 = findViewById(R.id.radioOption1);
        radioOption2 = findViewById(R.id.radioOption2);
        checkOption1 = findViewById(R.id.checkOption1);
        checkOption2 = findViewById(R.id.checkOption2);
        textViewResult = findViewById(R.id.textViewResult);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String selectedRadioOption = "";
                if (checkedId == R.id.radioOption1) {
                    selectedRadioOption = "Option 1";
                } else if (checkedId == R.id.radioOption2) {
                    selectedRadioOption = "Option 2";
                }
                textViewResult.setText("Selected Options: " + selectedRadioOption);
            }
        });

        checkOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCheckboxResult();
            }
        });

        checkOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCheckboxResult();
            }
        });
    }

    private void updateCheckboxResult() {
        String selectedCheckOptions = "";
        if (checkOption1.isChecked()) {
            selectedCheckOptions += "Check Option 1, ";
        }
        if (checkOption2.isChecked()) {
            selectedCheckOptions += "Check Option 2";
        }
        textViewResult.setText("Selected Options: " + selectedCheckOptions);
    }

}
