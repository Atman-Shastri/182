package com.example.frame_by_frame_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class frame_by_frame extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_by_frame);
        imageView = findViewById(R.id.imageView);

    }


    public void startAnimation(View view) {
        imageView.setImageResource(R.drawable.running_animation);
        AnimationDrawable run = (AnimationDrawable) imageView.getDrawable();
        run.start();
    }
}