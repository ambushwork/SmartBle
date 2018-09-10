package com.netatmo.ylu.smartble.nap;

import com.netatmo.ylu.smart_ble.BleManager;
import com.netatmo.ylu.smart_ble.BluetoothLEDevice;
import com.netatmo.ylu.smart_ble.OnDeviceChangeListener;
import com.netatmo.ylu.smartble.App;
import com.netatmo.ylu.smartble.AppComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NapManager {

    private List<Accessory> reachableAccessories = new ArrayList<>();

    protected BleManager bleManager;

    public NapManager(BleManager bleManager){
        this.bleManager = bleManager;
    }

    public void startScan(){
        bleManager.startScan();
    }

    public void addListener(final OnDeviceListChange listListener){
        bleManager.setScanListener(new OnDeviceChangeListener<Accessory>() {
            @Override
            public void onDeviceFound(Accessory accessory) {
                reachableAccessories.add(accessory);
                listListener.onChange(reachableAccessories);
            }

            @Override
            public void onDeviceLost(Accessory accessory) {
                reachableAccessories.remove(accessory);
                listListener.onChange(reachableAccessories);
            }
        }, new AccessoryConverter());
    }
}
