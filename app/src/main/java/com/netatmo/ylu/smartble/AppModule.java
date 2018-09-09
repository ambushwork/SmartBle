package com.netatmo.ylu.smartble;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public Context getApplicationContext(){
        return null;
    }
}
