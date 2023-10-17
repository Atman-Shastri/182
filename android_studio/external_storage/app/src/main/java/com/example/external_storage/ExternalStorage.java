package com.example.external_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExternalStorage extends AppCompatActivity {

    EditText editText;
    TextView responseView;
    Button saveButton;

    public String filename = "Sample.txt";

    private String filepath = "MyFilePath";

    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        editText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.save_button);
        responseView = findViewById(R.id.textView);

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveButton.setEnabled(false);
        } else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
    }

    private static boolean isExternalStorageAvailable() {
        String externalStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(externalStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageReadOnly() {
        String externalStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState)) {
            return true;
        }
        return false;
    }

    public void save(View view) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(myExternalFile);
            fileOutputStream.write(editText.getText().toString().getBytes());
            fileOutputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        editText.setText("");
        responseView.setText("SampleFile.txt saved to " + String.valueOf(getExternalFilesDir(filename)));
        Log.d("External Storage", String.valueOf(getExternalFilesDir(filename)));
    }

    public void load(View view) {
        try {
            FileInputStream fileInputStream = new FileInputStream(myExternalFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                myData += line;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        editText.setText(myData);
    }
}