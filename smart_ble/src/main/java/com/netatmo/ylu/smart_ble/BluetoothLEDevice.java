package com.netatmo.ylu.smart_ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.SystemClock;
import android.support.annotation.NonNull;

import java.util.List;

public class BluetoothLEDevice {
    private String name;
    private String macAddress;
    private ScanResult rawScanResult;
    private long lastSeen;
    private BluetoothDevice bluetoothDevice;

    private static final long DEFAULT_ADVERTISEMENT_INTERVAL= 1000000L;
    private static final int DEFAULT_LOST_TOLERANCE = 5;

    private BluetoothLEDevice(String name,long lastSeen,BluetoothDevice bluetoothDevice) {
        this.name = name;
        this.bluetoothDevice = bluetoothDevice;
        this.lastSeen = lastSeen;
    }

    public String getName() {
        return name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public long getLastSeen() {
        return lastSeen;
    }

    public void updateDevice(BluetoothLEDevice bluetoothLEDevice){
        this.lastSeen = bluetoothLEDevice.getLastSeen();
        this.name = bluetoothLEDevice.getName();
    }

    public BluetoothDevice getBluetoothDevice() {
        return bluetoothDevice;
    }

    public long getAdvertisementInterval(){
        return DEFAULT_ADVERTISEMENT_INTERVAL;
    }

    public int getLostTolerance(){
        return DEFAULT_LOST_TOLERANCE;
    }

    public boolean isOutdated(){
        return System.currentTimeMillis() - lastSeen >
                getAdvertisementInterval() * getLostTolerance();
    }

    @NonNull
    public String getIdentity(){
        return getMacAddress();
    }

    public static BluetoothLEDevice createDevice(ScanResult scanResult){
        BluetoothDevice bluetoothDevice = scanResult.getDevice();
        long lastSeen = System.currentTimeMillis() -
                SystemClock.elapsedRealtime() +
                scanResult.getTimestampNanos() / 1000000;
        ScanRecord scanRecord = scanResult.getScanRecord();
        String deviceName = null;
        if(scanRecord != null){
            deviceName = scanRecord.getDeviceName();
        }
        return new BluetoothLEDevice(deviceName,lastSeen,bluetoothDevice);

    }

    public static List<BluetoothLEDevice> createDevices(List<ScanResult> scanResults){
        //todo
        return null;
    }


}
