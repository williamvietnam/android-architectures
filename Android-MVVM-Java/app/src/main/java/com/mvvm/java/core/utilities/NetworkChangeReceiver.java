/*
Copyright (c) 2021 All Rights Reserved, Nudge SA.
*/
package com.mvvm.java.core.utilities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            if (!NetworkUtilities.isConnectedToNetwork(context)) {
                Log.d(NetworkChangeReceiver.class.getName(), "onReceive()...");
            }
        } catch (NullPointerException e) {
            Log.d(NetworkChangeReceiver.class.getName(), "error()...");
        }
    }
}

