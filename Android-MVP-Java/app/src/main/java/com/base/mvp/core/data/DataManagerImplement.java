package com.base.mvp.core.data;

import android.content.Context;

import com.base.mvp.core.data.local.database.DatabaseHelper;
import com.base.mvp.core.data.local.preferences.PreferencesHelper;
import com.base.mvp.core.data.remote.ApiHelper;
import com.base.mvp.core.di.ApplicationContext;

import javax.inject.Inject;

public class DataManagerImplement implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context context;
    private final DatabaseHelper databaseHelper;
    private final PreferencesHelper preferencesHelper;
    private final ApiHelper apiHelper;

    @Inject
    public DataManagerImplement(
            @ApplicationContext Context context,
            DatabaseHelper databaseHelper,
            PreferencesHelper preferencesHelper,
            ApiHelper apiHelper
    ) {
        this.context = context;
        this.databaseHelper = databaseHelper;
        this.preferencesHelper = preferencesHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public Long getCurrentUserId() {
        return preferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        preferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getAccessToken() {
        return preferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        preferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public boolean isShowedWelcomeScreen() {
        return false;
    }

    @Override
    public void setShowedWelcomeScreen() {

    }

    @Override
    public void clearAllDataExceptWelcome() {

    }
}
