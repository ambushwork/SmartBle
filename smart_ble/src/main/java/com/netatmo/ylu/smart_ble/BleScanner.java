package com.netatmo.ylu.smart_ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BleScanner {
    private BluetoothLeScanner bluetoothLeScanner;
    private final Context mContext;
    private ScanCallback mScanCallback;
    private List<ScanFilter> scanFilters;
    private ScanSettings scanSettings;
    private BLEDeviceStore deviceStore ;

    public BleScanner(Context mContext, BLEDeviceStore store) {
        this.mContext = mContext;
        this.deviceStore = store;
        init();
    }

    private void init() {
        final BluetoothManager bluetoothManager =
                (BluetoothManager) mContext.getSystemService(Context.BLUETOOTH_SERVICE);
        if (bluetoothManager == null) {
            Log.e("BleScanner", "Can't get BluetoothManager.");
            return;
        }
        BluetoothAdapter mBluetoothAdapter = bluetoothManager.getAdapter();
        //todo to discuss
        scanSettings = new ScanSettings.Builder()
                .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
                .build();
        scanFilters = new ArrayList<>();
        bluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
        mScanCallback = new ScanCallback() {
            @Override
            public void onScanResult(int callbackType, ScanResult result) {
                super.onScanResult(callbackType, result);
                deviceStore.addDevice(BluetoothLEDevice.createDevice(result));
            }

            @Override
            public void onBatchScanResults(List<ScanResult> results) {
                super.onBatchScanResults(results);
                //todo
            }

            @Override
            public void onScanFailed(int errorCode) {
                super.onScanFailed(errorCode);
            }
        };
    }

    public void addScanFilter(ScanFilter scanFilter) {
        scanFilters.add(scanFilter);
    }

    public void start() {
        bluetoothLeScanner.startScan(scanFilters, scanSettings, mScanCallback);
    }

    public void stop() {
        bluetoothLeScanner.stopScan(mScanCallback);
    }

    public void addScanFilters(ScanFilter scanFilter) {
        scanFilters.add(scanFilter);
    }
}
