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
    private ScanResultResolver resultResolver;
    private BleScanParameters parameters;

    public BleScanner(Context mContext) {
        this.mContext = mContext;
        init();
    }

    private void init(){
        final BluetoothManager bluetoothManager =
                (BluetoothManager) mContext.getSystemService(Context.BLUETOOTH_SERVICE);
        if(bluetoothManager == null){
            Log.e("BleScanner","Can't get BluetoothManager.");
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
                resultResolver.onResolve(result);
            }

            @Override
            public void onBatchScanResults(List<ScanResult> results) {
                super.onBatchScanResults(results);
            }

            @Override
            public void onScanFailed(int errorCode) {
                super.onScanFailed(errorCode);
            }
        };
    }

    private ScanFilter initScanFilter(){
        if(parameters == null){
            return null;
        }
        ScanFilter.Builder builder = new ScanFilter.Builder();
        builder.setManufacturerData(parameters.getManufacturerId(),
                parameters.getManufacturerByte(),
                parameters.getManufacturerByteMask());
        return null;

    }

    public void start(){
        bluetoothLeScanner.startScan(scanFilters,scanSettings,mScanCallback);
    }

    public void stop(){
        bluetoothLeScanner.stopScan(mScanCallback);
    }

    public void addScanFilters(ScanFilter scanFilter){
        scanFilters.add(scanFilter);
    }

    public void setResultResolver(ScanResultResolver resultResolver){
        this.resultResolver = resultResolver;
    }

    public void setParameters(BleScanParameters parameters){
        this.parameters = parameters;
    }
}
