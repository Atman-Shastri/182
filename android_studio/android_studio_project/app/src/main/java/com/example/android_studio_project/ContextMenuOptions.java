package com.example.android_studio_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ContextMenuOptions extends AppCompatActivity {

    ImageView imageView;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.google) {
            Intent googleIntent = new Intent(this, OpenGoogle.class);
            startActivity(googleIntent);
            Toast.makeText(this, "Google", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.facebook) {
            Intent facebookIntent = new Intent(this, OpenFacebook.class);
            startActivity(facebookIntent);
        } else {
            return super.onContextItemSelected(item);
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_options);
        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);
    }
}