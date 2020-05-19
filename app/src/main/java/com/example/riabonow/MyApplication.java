package com.example.riabonow;

import android.app.Application;

import com.example.riabonow.utils.AppInfo;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppInfo.createInstance(this);
    }
}
