package com.netatmo.ylu.smartble;

public class ScanPresenter implements Contract.Presenter {
    Contract.View view;
    @Override
    public void onButtonPressed() {
        //logic
    }

    @Override
    public void requestUpdate(String deviceId) {
        //logic
    }

    @Override
    public void registerView(Contract.View view) {
        this.view = view;
    }
}
