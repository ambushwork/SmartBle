package com.netatmo.ylu.smart_ble;

public interface DeviceFilter {
    public boolean match(BluetoothLEDevice bluetoothLEDevice);
}
