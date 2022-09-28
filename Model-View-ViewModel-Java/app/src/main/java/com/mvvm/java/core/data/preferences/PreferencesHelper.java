package com.mvvm.java.core.data.preferences;

public interface PreferencesHelper {

    String getAccessToken();

    void setAccessToken(String accessToken);

    /**
     * @return is showed welcome screen or not
     */
    boolean isShowedWelcomeScreen();

    /**
     * we showed welcome screen, no need to show
     */
    void setShowedWelcomeScreen();

    /**
     * when logout, we clear all data except data about welcome screen
     * we also clear all database in here
     */
    void clearAllDataExceptWelcome();
}