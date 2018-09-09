package com.netatmo.ylu.smart_ble;

public interface OnDeviceChangeListener {
    void onDeviceFound(BluetoothLEDevice bluetoothLEDevice);
    void onDeviceLost(BluetoothLEDevice bluetoothLEDevice);
}
