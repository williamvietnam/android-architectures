package com.mvvm.java.core.di.module;

import android.app.Application;
import android.content.Context;

import com.mvvm.java.core.data.DataManager;
import com.mvvm.java.core.data.DataManagerImplement;
import com.mvvm.java.core.data.database.RoomDatabaseHelper;
import com.mvvm.java.core.data.database.RoomDatabaseImplement;
import com.mvvm.java.core.data.network.ApiHelper;
import com.mvvm.java.core.data.network.ApiHelperImplement;
import com.mvvm.java.core.data.preferences.PreferencesHelper;
import com.mvvm.java.core.data.preferences.PreferencesImplement;
import com.mvvm.java.core.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImplement dataManagerImplement) {
        return dataManagerImplement;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesImplement preferencesImplement) {
        return preferencesImplement;
    }

    @Provides
    @Singleton
    RoomDatabaseHelper provideRoomDatabaseHelper(RoomDatabaseImplement databaseImplement) {
        return databaseImplement;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHelperImplement apiHelperImplement) {
        return apiHelperImplement;
    }
}