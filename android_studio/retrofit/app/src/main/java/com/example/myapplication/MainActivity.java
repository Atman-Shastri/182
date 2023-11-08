package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ScrollingView;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view_field);
        textView.setMovementMethod(new ScrollingMovementMethod());
        getRecords();
    }

    private void getRecords() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        API api = retrofit.create(API.class);

        Call<List<MyClass>> call = api.getRecords();
        call.enqueue(new Callback<List<MyClass>>() {
            @Override
            public void onResponse(Call<List<MyClass>> call, Response<List<MyClass>> response) {
                List<MyClass> list = response.body();
                for (int i = 0; i < list.size(); i++) {
                    textView.append(list.get(i).getLogin() + ", " + list.get(i).getNode_id());

                }

            }

            @Override
            public void onFailure(Call<List<MyClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR!!! TRY AGAIN LATER", Toast.LENGTH_LONG).show();
            }
        });

    }
}