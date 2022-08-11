package com.base.mvp.core.data.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.base.mvp.core.di.ApplicationContext;
import com.base.mvp.core.di.PreferenceInfo;
import com.base.mvp.core.utilities.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferencesHelperImplement implements PreferencesHelper {

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF_KEY_IS_SHOW_WELCOME_SCREEN = "PREF_KEY_IS_SHOW_WELCOME_SCREEN";

    private final SharedPreferences prefs;

    @Inject
    public PreferencesHelperImplement(@ApplicationContext Context context,
                                      @PreferenceInfo String prefFileName) {
        this.prefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public Long getCurrentUserId() {
        long userId = this.prefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX ? null : userId;
    }

    @Override
    public void setCurrentUserId(Long userId) {
        long id = userId == null ? AppConstants.NULL_INDEX : userId;
        this.prefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    @Override
    public String getAccessToken() {
        return this.prefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        this.prefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public boolean isShowedWelcomeScreen() {
        return prefs.getBoolean(PREF_KEY_IS_SHOW_WELCOME_SCREEN, false);
    }

    @Override
    public void setShowedWelcomeScreen() {
        prefs.edit().putBoolean(PREF_KEY_IS_SHOW_WELCOME_SCREEN, true).apply();
    }

    @Override
    public void clearAllDataExceptWelcome() {

    }
}
