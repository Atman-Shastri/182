package com.example.internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class internalStorage extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";

    EditText editText;  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        editText = findViewById(R.id.editText);
    }

    public void save(View view) {
        String text = editText.getText().toString();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());

            editText.getText().clear();

            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
            Log.d("FileName", getFilesDir() + "/" + FILE_NAME);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void load(View view) throws IOException {

        FileInputStream fileinputStream = null;
        try {
            fileinputStream = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileinputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String text;

            while((text = bufferedReader.readLine()) != null){
                stringBuilder.append(text).append("\n");
            }

            editText.setText(stringBuilder.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (fileinputStream != null) {
                fileinputStream.close();
            }
        }
    }
}