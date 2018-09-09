package com.netatmo.ylu.smartble;

import com.netatmo.ylu.smart_ble.BleManager;
import com.netatmo.ylu.smart_ble.BluetoothLEDevice;
import com.netatmo.ylu.smart_ble.DeviceConverter;
import com.netatmo.ylu.smart_ble.OnDeviceListListener;

import java.util.List;

import javax.inject.Inject;

public class NapManager {

    @Inject
    private BleManager bleManager;

    public NapManager(){
        //inject
    }

    public void addListener(String tag, OnDeviceListListener<Accessory> listListener){
        bleManager.addListListener(tag,listListener, new DeviceConverter<Accessory>() {
            @Override
            public Accessory convert(BluetoothLEDevice bluetoothLEDevice) {
                return new Accessory(bluetoothLEDevice.getName(),bluetoothLEDevice.getMacAddress());
            }
        });
    }
}
