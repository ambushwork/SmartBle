package com.netatmo.ylu.smart_ble;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BleManager {

    private BLEDeviceStore deviceStore;
    private BleScanner scanner;
    private HashMap<String, List<?>> listenerMap;

    public BleManager(@NonNull BleScanner scanner, @NonNull BLEDeviceStore store){
        this.scanner = scanner;
        this.deviceStore = store;
    }

    public void startScan(){
        scanner.start();
    }

    @Nullable
    public BluetoothLEDevice getDevice(String deviceId){
        return deviceStore.getDevice(deviceId);
    }

    public <T> BluetoothLEDevice addListListener(final String tag,
                                                 final OnDeviceListListener<T> listListener,
                                                 final DeviceConverter<T> converter){

        if(! listenerMap.containsKey(tag)){
            listenerMap.put(tag, new ArrayList<T>());
        }
        deviceStore.addListener(new OnDeviceChangeListener() {
            @Override
            public void onDeviceFound(BluetoothLEDevice bluetoothLEDevice) {
                T device = converter.convert(bluetoothLEDevice);
                listenerMap.get(tag).add(device);
                listListener.onDeviceListChanged(listenerMap.get(tag));
            }

            @Override
            public void onDeviceLost(BluetoothLEDevice bluetoothLEDevice) {
                T device = converter.convert(bluetoothLEDevice);
                listenerMap.get(tag).remove(device);
                listListener.onDeviceListChanged(listenerMap.get(tag));
            }
        });
    }



}
