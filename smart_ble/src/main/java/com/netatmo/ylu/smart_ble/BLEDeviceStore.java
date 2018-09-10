package com.netatmo.ylu.smart_ble;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLEDeviceStore {

    @NonNull
    private final Map<String, BluetoothLEDevice> deviceMap;
    @Nullable
    private OnDeviceChangeListener<BluetoothLEDevice> deviceChangeListener ;

    public BLEDeviceStore() {
        deviceMap = new HashMap<>();
    }

    public void addDevice(@NonNull BluetoothLEDevice bluetoothLEDevice){
        if(deviceMap.containsKey(bluetoothLEDevice.getIdentity())){
            deviceMap.get(bluetoothLEDevice.getIdentity()).updateDevice(bluetoothLEDevice);
        } else {
            deviceMap.put(bluetoothLEDevice.getIdentity(), bluetoothLEDevice);
            if(deviceChangeListener != null) {
                deviceChangeListener.onDeviceFound(bluetoothLEDevice);
            }
        }
    }

    public void removeDevice(@NonNull BluetoothLEDevice bluetoothLEDevice){
        removeDevice(bluetoothLEDevice.getIdentity());
    }

    public void removeDevice(@NonNull String identity){
        if(deviceMap.containsKey(identity)){
            BluetoothLEDevice device = deviceMap.remove(identity);
            if(deviceChangeListener != null){
                deviceChangeListener.onDeviceLost(device);
            }

        }
    }

    @Nullable
    public BluetoothLEDevice getDevice(String identity){
        return deviceMap.get(identity);
    }

    public void clear() {
        deviceMap.clear();
    }

    public void setListener(@NonNull OnDeviceChangeListener<BluetoothLEDevice> listener){
        deviceChangeListener = listener;
    }

}
