package com.netatmo.ylu.smart_ble;

public interface DeviceConverter<T> {
    T convert(BluetoothLEDevice bluetoothLEDevice);
}
