package com.base.mvp.core.di.module;

import android.app.Application;
import android.content.Context;

import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.data.DataManagerImplement;
import com.base.mvp.core.data.local.preferences.PreferencesHelper;
import com.base.mvp.core.data.local.preferences.PreferencesHelperImplement;
import com.base.mvp.core.data.remote.ApiHelper;
import com.base.mvp.core.data.remote.ApiHelperImplement;
import com.base.mvp.core.di.ApplicationContext;

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
    DataManager provideDataManager(DataManagerImplement dataManagerImpl) {
        return dataManagerImpl;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperImplement preferencesHelperImpl) {
        return preferencesHelperImpl;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHelperImplement apiHelperImpl) {
        return apiHelperImpl;
    }

}
