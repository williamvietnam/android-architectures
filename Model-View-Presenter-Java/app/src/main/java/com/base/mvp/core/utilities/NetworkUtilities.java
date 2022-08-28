package com.base.mvp.core.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.annotation.NonNull;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public final class NetworkUtilities {

    private NetworkUtilities() {
        // This utility class is not publicly instantiable
    }

    public static boolean isNetworkConnected(@NonNull Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static boolean isConnectedToNetwork(@NonNull Context context) {
        Context contextApplication = context.getApplicationContext();
        ConnectivityManager connectivityManager =
                (ConnectivityManager) contextApplication.getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean isConnected = false;
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            isConnected = (activeNetwork != null) && (activeNetwork.isConnectedOrConnecting());
        }

        return isConnected;
    }
}
