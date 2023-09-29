package com.example.android_studio_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MediaPlayerBackgroundService extends AppCompatActivity {
    Button startButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_background_service);
        startButton = findViewById(R.id.button);
        stopButton = findViewById(R.id.button2);
    }

    public void StartMediaPlayer(View view) {
        Intent intent = new Intent(this, MediaPlayerService.class);
        startService(intent);
    }

    public void StopMediaPlayer(View view) {
        Intent intent = new Intent(this, MediaPlayerService.class);
        stopService(intent);
    }
}