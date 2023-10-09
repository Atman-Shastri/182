package com.example.image_operations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class image_operations extends AppCompatActivity {

    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_operations);
        imageview = (ImageView)findViewById(R.id.imageView4);
    }

    public void fade(View view) {
    Animation fading = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
    imageview.startAnimation(fading);
    }

    public void rotate(View view){
        Animation fading = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        imageview.startAnimation(fading);
    }

    public void expand(View view){
        Animation fading = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.expand);
        imageview.startAnimation(fading);
    }

    public void set(View view){
        Animation fading = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.set);
        imageview.startAnimation(fading);
    }

    public void move(View view){
        Animation fading = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        imageview.startAnimation(fading);
    }
}