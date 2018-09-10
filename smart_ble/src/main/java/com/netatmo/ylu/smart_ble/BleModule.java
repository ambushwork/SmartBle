package com.netatmo.ylu.smart_ble;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BleModule {

    @Provides
    @Singleton
    public BleScanner provideBleScanner(Context context,@NonNull BLEDeviceStore store){
        return new BleScanner(context, store);
    }

    @Provides
    @Singleton
    public BLEDeviceStore provideBleStore(){
        return new BLEDeviceStore();
    }

    @Provides
    @Singleton
    public BleManager provideBleManager(BLEDeviceStore store, BleScanner scanner){
        return new BleManager(scanner, store);
    }
}
