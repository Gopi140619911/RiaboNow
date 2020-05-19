package com.example.riabonow.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AppNavigator {
    public static boolean handleAction(Context context, String action) {
        return handleAction(context, action, null, 0);
    }

    public static boolean handleAction(Context context, String action, Bundle bundle) {
        return handleAction(context, action, bundle, 0);
    }

    public static boolean handleActionForResult(Activity context, String action, int reqCode, Bundle bundle) {
        return handleActionForResult(context, action, reqCode, bundle,0);
    }

    public static boolean handleAction(Context context, String action, Bundle bundle, int flags) {
        Intent intent = new Intent(action);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        if (0 != flags) {
            intent.addFlags(flags);
        }
        try {
            if (context instanceof Activity) {
                context.startActivity(intent);
            } else {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static boolean handleActionForResult(Activity context, String action, int reqCode, Bundle bundle, int flags) {
        Intent intent = new Intent(action);
        intent.setPackage(AppInfo.getInstance().getApplication().getPackageName());
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        if (0 != flags) {
            intent.addFlags(flags);
        }

        try {
            context.startActivityForResult(intent, reqCode);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
