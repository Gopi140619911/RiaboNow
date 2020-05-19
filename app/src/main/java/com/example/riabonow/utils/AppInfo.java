package com.example.riabonow.utils;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AppInfo {

    private Application application;
    private static AppInfo sInstance;
    private AppLifecycleCallback appLifecycleCallback;

    private AppInfo(@NonNull Application application) {
        this.application = application;
        this.appLifecycleCallback = new AppLifecycleCallback();
        this.application.registerActivityLifecycleCallbacks(this.appLifecycleCallback);
    }


    public synchronized static AppInfo getInstance() {
        if (sInstance == null)
            throw new RuntimeException("not init");
        return sInstance;
    }

    @NonNull
    public synchronized static AppInfo createInstance(@NonNull Application application
    ) {
        if (sInstance == null) {
            sInstance = new AppInfo(application);
        }
        return sInstance;
    }


    @NonNull
    public Application getApplication() {
        return application;
    }

    @Nullable
    public Activity getTopActivity() {
        return this.appLifecycleCallback.getTopActivity();
    }

}
