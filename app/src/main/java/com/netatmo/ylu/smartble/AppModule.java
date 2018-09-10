package com.netatmo.ylu.smartble;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.netatmo.ylu.smart_ble.BleManager;
import com.netatmo.ylu.smartble.nap.NapManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getApplicationContext(){
        return context;
    }

    @Provides
    @Singleton
    public NapManager provideNapManager(BleManager bleManager){
        return new NapManager(bleManager);
    }
}
