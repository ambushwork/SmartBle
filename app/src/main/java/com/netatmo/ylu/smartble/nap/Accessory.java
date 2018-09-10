package com.netatmo.ylu.smartble.nap;

import com.netatmo.ylu.smart_ble.BluetoothLEDevice;

public class Accessory {
    private String name;
    private String accessoryId;

    public Accessory(String name, String accessoryId) {
        this.name = name;
        this.accessoryId = accessoryId;
    }

    public String getName() {
        return name;
    }

    public String getAccessoryId() {
        return accessoryId;
    }
}
