package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    ImageView imageView;

    Button getData;

    RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_field);
        imageView = findViewById(R.id.image_field);
        mQueue = Volley.newRequestQueue(this);
        getData = findViewById(R.id.ui_button);
    }

    public void getData(View view) {
        JsonParse();
    }

    private void JsonParse() {
        String url = "https://api.github.com/users/ezmobius";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {

                    String login = response.getString("login");
                    String id = response.getString("id");
                    String node_id = response.getString("node_id");
                    String img_url = response.getString("avatar_url");
                    textView.setText("Login: " + login + "ID: " + id + "Node ID: " + node_id);
                    Picasso.get().load(img_url).into(imageView);
                } catch (JSONException jsonException) {
                    jsonException.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}