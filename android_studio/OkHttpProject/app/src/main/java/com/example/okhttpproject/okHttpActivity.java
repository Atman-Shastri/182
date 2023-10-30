package com.example.okhttpproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class okHttpActivity extends AppCompatActivity {
    TextView textView;

    Button uiContactsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        textView = findViewById(R.id.textview_field);
        uiContactsButton = findViewById(R.id.button_id);

        uiContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestData requestData = new RequestData();
                requestData.execute();

            }
        });
    }

    public class RequestData extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {

            BufferedReader reader = null;

            try {


            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            textView.setText(o.toString());
            textView.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}