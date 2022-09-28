package com.mvvm.java.core.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.mvvm.java.core.di.ApplicationContext;
import com.mvvm.java.core.di.PreferenceInfo;

import javax.inject.Inject;

public class PreferencesImplement implements PreferencesHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF_KEY_IS_SHOW_WELCOME_SCREEN = "PREF_KEY_IS_SHOW_WELCOME_SCREEN";

    private final SharedPreferences sharedPreferences;

    @Inject
    public PreferencesImplement(@NonNull @ApplicationContext Context context,
                                      @PreferenceInfo String prefFileName) {
        this.sharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAccessToken() {
        return this.sharedPreferences.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        this.sharedPreferences.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public boolean isShowedWelcomeScreen() {
        return sharedPreferences.getBoolean(PREF_KEY_IS_SHOW_WELCOME_SCREEN, false);
    }

    @Override
    public void setShowedWelcomeScreen() {
        sharedPreferences.edit().putBoolean(PREF_KEY_IS_SHOW_WELCOME_SCREEN, true).apply();
    }

    @Override
    public void clearAllDataExceptWelcome() {

    }
}