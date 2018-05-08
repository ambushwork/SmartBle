package com.netatmo.ylu.smart_ble;

import android.bluetooth.le.ScanResult;

public interface ScanResultResolver {
    void onResolve(ScanResult scanResult);
}
