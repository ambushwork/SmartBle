package com.netatmo.ylu.smartble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.netatmo.ylu.smartble.nap.Accessory;
import com.netatmo.ylu.smartble.nap.NapManager;
import com.netatmo.ylu.smartble.nap.OnDeviceListChange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity{

    @Inject
    protected NapManager napManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getAppComponent().inject(this);
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final DeviceAdapter adapter = new DeviceAdapter(getApplicationContext());
        adapter.setDevices(Collections.singletonList(new Accessory("1","1")));
        recyclerView.setAdapter(adapter);

        napManager.addListener(new OnDeviceListChange() {
            @Override
            public void onChange(List<Accessory> accessories) {
                adapter.setDevices(accessories);
                adapter.notifyDataSetChanged();
            }
        });
        napManager.startScan();
    }
}
