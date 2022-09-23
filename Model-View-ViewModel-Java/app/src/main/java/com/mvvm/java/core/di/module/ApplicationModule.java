package com.mvvm.java.core.di.module;

import android.app.Application;
import android.content.Context;

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

//    @Provides
//    @Singleton
//    DataManager provideDataManager(DataManagerImplement dataManagerImpl) {
//        return dataManagerImpl;
//    }
//
    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesImplement preferencesHelperImpl) {
        return preferencesHelperImpl;
    }
//
//    @Provides
//    @Singleton
//    ApiHelper provideApiHelper(ApiHelperImplement apiHelperImpl) {
//        return apiHelperImpl;
//    }

}
