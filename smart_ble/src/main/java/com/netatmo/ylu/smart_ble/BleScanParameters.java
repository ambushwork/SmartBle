package com.netatmo.ylu.smart_ble;

public class BleScanParameters {
    private int manufacturerId;
    private byte[] manufacturerByte;
    private byte[] manufacturerByteMask;

    public BleScanParameters(int manufacturerId, byte[] manufacturerByte, byte[] manufacturerByteMask) {
        this.manufacturerId = manufacturerId;
        this.manufacturerByte = manufacturerByte;
        this.manufacturerByteMask = manufacturerByteMask;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public byte[] getManufacturerByte() {
        return manufacturerByte;
    }

    public void setManufacturerByte(byte[] manufacturerByte) {
        this.manufacturerByte = manufacturerByte;
    }

    public byte[] getManufacturerByteMask() {
        return manufacturerByteMask;
    }

    public void setManufacturerByteMask(byte[] manufacturerByteMask) {
        this.manufacturerByteMask = manufacturerByteMask;
    }
}
