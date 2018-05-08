package com.netatmo.ylu.smartble;

import android.bluetooth.le.ScanResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.netatmo.ylu.smart_ble.BleScanner;
import com.netatmo.ylu.smart_ble.ScanResultResolver;

public class MainActivity extends AppCompatActivity {
    BleScanner bleScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bleScanner = new BleScanner(getApplicationContext());
        bleScanner.setResultResolver(new ScanResultResolver() {
            @Override
            public void onResolve(ScanResult scanResult) {
                Log.v("Scan result",scanResult.getDevice().getAddress());
            }
        });
        bleScanner.start();




    }
}