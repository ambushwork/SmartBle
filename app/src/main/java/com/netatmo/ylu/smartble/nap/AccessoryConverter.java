package com.netatmo.ylu.smartble.nap;

import com.netatmo.ylu.smart_ble.BluetoothLEDevice;
import com.netatmo.ylu.smart_ble.DeviceConverter;

public class AccessoryConverter implements DeviceConverter<Accessory> {
    @Override
    public Accessory convert(BluetoothLEDevice bluetoothLEDevice) {
        return new Accessory(bluetoothLEDevice.getName(),
                bluetoothLEDevice.getMacAddress());
    }
}
