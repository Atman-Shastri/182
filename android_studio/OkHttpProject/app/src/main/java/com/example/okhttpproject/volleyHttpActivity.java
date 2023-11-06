package com.example.okhttpproject;

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
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Queue;

public class volleyHttpActivity extends AppCompatActivity {

    TextView textView;

    ImageView imageView;

    Button getData;

    com.android.volley.RequestQueue mQueue = Volley.newRequestQueue(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_http_activty);

        textView = findViewById(R.id.textview_field);
        imageView = findViewById(R.id.image_field);

        getData = findViewById(R.id.ui_button);
    }

    public void getData(View view) {
        JsonParse();
    }

    private void JsonParse(){
        String url = "https://api.github.com/users/ezmobius";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                    try{

                        String login = response.getString("login");
                        String id = response.getString("id");
                        String node_id = response.getString("node_id");
                        String img_url = response.getString("img_url");
                        textView.setText("Login: " + login + "ID: " + id + "Node ID: "+ node_id);
                        Picasso.get().load(img_url).into(imageView);
                    }catch (JSONException jsonException ){
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