package com.netatmo.ylu.smart_ble;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BleModule {

    @Provides
    @NonNull
    @Singleton
    public BleScanner provideBleScanner(Context context){
        return new BleScanner(context);
    }

    @Provides
    @NonNull
    @Singleton
    public BLEDeviceStore provideBleStore(){
        return new BLEDeviceStore();
    }

    @Provides
    @NonNull
    @Singleton
    public BleManager provideBleManager(BLEDeviceStore store, BleScanner scanner){
        return new BleManager(scanner, store);
    }
}
