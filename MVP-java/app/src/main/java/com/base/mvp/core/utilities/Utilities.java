package com.base.mvp.core.utilities;

import android.app.ActivityManager;
import android.content.Context;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public class Utilities {
    /**
     * This method using to check application is foreground mode
     *
     * @param context {@link Context}
     *
     * @return true/false
     */
    public static boolean isForegroundApp(@NonNull Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                    && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }
}
