package com.example.coordinates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class coordinates extends AppCompatActivity implements LocationListener {
    TextView textView;
    Button button;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinates);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        if (ContextCompat.checkSelfPermission(coordinates.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.INTERNET}, 101);

        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
//        textView.setText(
//                "Longitude: " +
//                location.getLongitude() +
//                        "\n" +
//                        "Latitude: " +
//                        location.getLatitude()
//        );

        Geocoder geocoder = new Geocoder(coordinates.this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),
                    location.getLongitude(), 1);

            Address obj = addresses.get(0);
            String add = obj.getAddressLine(0);
            add += "\n" + obj.getCountryName();
            add += "\n" + obj.getCountryCode();
            add += "\n" + obj.getAdminArea();
            add += "\n" + obj.getPostalCode();
            add += "\n" + obj.getSubAdminArea();
            add += "\n" + obj.getLocality();
            add += "\n" + obj.getSubThoroughfare();

            Toast.makeText(this, "Address: " + add, Toast.LENGTH_LONG).show();
            textView.setText(add);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            Toast.makeText(this, "IOException: " + ioException.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }


    public void BtnClick(View view) {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, this);

        } catch (SecurityException exception) {
            exception.printStackTrace();
        }
    }
}