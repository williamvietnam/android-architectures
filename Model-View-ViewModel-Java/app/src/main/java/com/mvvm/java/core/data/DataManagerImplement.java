package com.mvvm.java.core.data;

import android.content.Context;

import com.mvvm.java.core.data.database.RoomDatabaseHelper;
import com.mvvm.java.core.data.network.ApiHelper;
import com.mvvm.java.core.data.network.models.response.ModelResponse;
import com.mvvm.java.core.data.preferences.PreferencesHelper;
import com.mvvm.java.core.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class DataManagerImplement implements DataManager {

    private static final String TAG = "DataManagerImplement";

    private final Context context;
    private final PreferencesHelper preferencesHelper;
    private final RoomDatabaseHelper databaseHelper;
    private final ApiHelper apiHelper;

    @Inject
    public DataManagerImplement(@ApplicationContext Context context,
                                PreferencesHelper preferencesHelper,
                                RoomDatabaseHelper databaseHelper,
                                ApiHelper apiHelper) {
        this.context = context;
        this.databaseHelper = databaseHelper;
        this.preferencesHelper = preferencesHelper;
        this.apiHelper = apiHelper;
    }

    //---------------------------------- Preferences data -----------------------------------------
    @Override
    public PreferencesHelper getPreferenceInstance() {
        return this.preferencesHelper;
    }


    @Override
    public String getAccessToken() {
        return this.preferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        this.preferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public boolean isShowedWelcomeScreen() {
        return this.preferencesHelper.isShowedWelcomeScreen();
    }

    @Override
    public void setShowedWelcomeScreen() {
        this.preferencesHelper.setShowedWelcomeScreen();
    }

    @Override
    public void clearAllDataExceptWelcome() {
        this.preferencesHelper.clearAllDataExceptWelcome();
    }

    //------------------------------------ Database data ------------------------------------------
    @Override
    public RoomDatabaseHelper getDatabaseInstance() {
        return this.databaseHelper;
    }


    //-------------------------------------- Api data ---------------------------------------------
    @Override
    public ApiHelper getApiInstance() {
        return this.apiHelper;
    }

    @Override
    public Single<List<ModelResponse>> getUsers() {
        return this.apiHelper.getUsers();
    }

    @Override
    public Single<List<ModelResponse>> getUsers(int pageIndex) {
        return this.apiHelper.getUsers(pageIndex);
    }

    @Override
    public Single<ModelResponse> getUserDetail(String userId) {
        return this.apiHelper.getUserDetail(userId);
    }
}