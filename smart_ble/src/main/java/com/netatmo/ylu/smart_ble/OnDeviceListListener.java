package com.netatmo.ylu.smart_ble;

import java.util.List;

public interface OnDeviceListListener<T> {
    void onDeviceListChanged(List<T> devices);
}
