package com.example.content_provider_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContentProviderActivity extends AppCompatActivity {

    TextView textView;

    Button uiContactsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        textView = findViewById(R.id.textview_field);
        uiContactsButton = findViewById(R.id.button_id);

        // On click listener for get contacts button
        uiContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ContentProviderActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                    {
                        ActivityCompat.requestPermissions(ContentProviderActivity.this, new String[]{
                                Manifest.permission.READ_CONTACTS}, 10);
                    }
                }

                ContentResolver contentResolver = getContentResolver();
                Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                Cursor cursor = contentResolver.query(uri, null, null, null, null);

                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        int displayNameColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                        String contactName = cursor.getString(displayNameColumnIndex);
                        int phoneNumberColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        String phoneNumber = cursor.getString(phoneNumberColumnIndex);
                        textView.append("Name: " + contactName + "\n" + "Number: " + phoneNumber + "\n\n");
                    }
                }
            }
        });
    }

}
