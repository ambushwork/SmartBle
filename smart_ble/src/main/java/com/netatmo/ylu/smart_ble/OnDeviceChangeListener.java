package com.netatmo.ylu.smart_ble;

public interface OnDeviceChangeListener<T> {
    void onDeviceFound(T bluetoothLEDevice);
    void onDeviceLost(T bluetoothLEDevice);
}
