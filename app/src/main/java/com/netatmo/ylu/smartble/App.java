package com.netatmo.ylu.smartble;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        appComponent = buildComponent();
    }

    public AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
