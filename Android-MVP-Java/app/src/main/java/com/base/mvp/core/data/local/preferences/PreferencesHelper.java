package com.base.mvp.core.data.local.preferences;

public interface PreferencesHelper {

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

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
