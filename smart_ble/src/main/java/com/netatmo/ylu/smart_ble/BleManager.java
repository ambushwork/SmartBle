package com.netatmo.ylu.smart_ble;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BleManager {

    private BLEDeviceStore deviceStore;
    private BleScanner scanner;
    private List<?> deviceList = new ArrayList<>();

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

    public <T> void setScanListener(final OnDeviceChangeListener<T> deviceChangeListener,
                                    final DeviceConverter<T> converter){

        deviceStore.setListener(new OnDeviceChangeListener<BluetoothLEDevice>() {

            @Override
            public void onDeviceFound(BluetoothLEDevice bluetoothLEDevice) {
                deviceChangeListener.onDeviceFound(converter.convert(bluetoothLEDevice));
            }

            @Override
            public void onDeviceLost(BluetoothLEDevice bluetoothLEDevice) {
                deviceChangeListener.onDeviceLost(converter.convert(bluetoothLEDevice));
            }
        });
    }

    public void setScanListener(final OnDeviceChangeListener<BluetoothLEDevice> deviceOnDeviceChangeListener){
        deviceStore.setListener(deviceOnDeviceChangeListener);
    }



}
