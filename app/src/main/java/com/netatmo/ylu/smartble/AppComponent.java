package com.netatmo.ylu.smartble;

import android.app.Activity;

import com.netatmo.ylu.smart_ble.BleModule;
import com.netatmo.ylu.smartble.nap.NapManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        BleModule.class,
        AppModule.class
})
public interface AppComponent {
    void inject(MainActivity activity);
}
