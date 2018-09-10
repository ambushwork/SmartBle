package com.netatmo.ylu.smartble.nap;

import java.util.List;

public interface OnDeviceListChange {
    void onChange(List<Accessory> accessories);
}
