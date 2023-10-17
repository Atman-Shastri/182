package com.example.wifi_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

public class WifiServiceActivity extends AppCompatActivity {
    TextView result_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_service);
        result_view = findViewById(R.id.result_field);
    }


    public void wifiOn(View view) {
        WifiControl.enableWifi(this);

        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled()) {
            result_view.setText("Wifi is on");
        }

    }


    public void wifiOff(View view) {
        WifiControl.disableWifi(this);
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            result_view.setText("Wifi is off");
        }

    }
}