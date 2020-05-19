package com.example.riabonow.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengruifr on 16/11/10.
 */
public class AppLifecycleCallback implements Application.ActivityLifecycleCallbacks {

    private List<WeakReference<Activity>> activityRefs = new ArrayList<WeakReference<Activity>>();


    @Nullable
    Activity getTopActivity() {
        if (0 == activityRefs.size()) {
            return null;
        }
        return activityRefs.get(activityRefs.size() - 1).get();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activityRefs.add(new WeakReference<Activity>(activity));
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        int size = activityRefs.size();
        for (int i = size - 1; i >= 0; i--) {
            Activity cache = activityRefs.get(i).get();
            if (cache == activity) {
                activityRefs.remove(i);
                return;
            }
        }
    }
}
