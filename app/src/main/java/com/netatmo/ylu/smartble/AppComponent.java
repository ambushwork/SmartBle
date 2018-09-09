package com.netatmo.ylu.smartble;

import dagger.Component;

@Component
public interface AppComponent {
    void inject(NapManager napManager);
}
