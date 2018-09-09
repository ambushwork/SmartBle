package com.netatmo.ylu.smartble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.netatmo.ylu.smart_ble.OnDeviceListListener;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity{

    @Inject private NapManager napManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view);
        final DeviceAdapter adapter = new DeviceAdapter(getApplicationContext());

        napManager.addListener("MainActivity", new OnDeviceListListener<Accessory>() {
            @Override
            public void onDeviceListChanged(List<Accessory> devices) {
                adapter.setDevices(devices);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}
