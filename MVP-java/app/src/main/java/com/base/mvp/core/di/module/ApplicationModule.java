package com.base.mvp.core.di.module;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.base.mvp.BuildConfig;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.data.DataManagerImplement;
import com.base.mvp.core.data.local.database.DatabaseHelper;
import com.base.mvp.core.data.local.database.DatabaseHelperImplement;
import com.base.mvp.core.data.local.preferences.PreferencesHelper;
import com.base.mvp.core.data.local.preferences.PreferencesHelperImplement;
import com.base.mvp.core.data.remote.ApiHeader;
import com.base.mvp.core.data.remote.ApiHelper;
import com.base.mvp.core.data.remote.ApiHelperImplement;
import com.base.mvp.core.di.ApiInfo;
import com.base.mvp.core.di.ApplicationContext;

import javax.inject.Singleton;
import com.base.mvp.R;
import com.base.mvp.core.di.DatabaseInfo;
import com.base.mvp.core.di.PreferenceInfo;
import com.base.mvp.core.utilities.AppConstants;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

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
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImplement dataManagerImplement) {
        return dataManagerImplement;
    }

    @Provides
    @Singleton
    DatabaseHelper provideDatabaseHelper(DatabaseHelperImplement databaseHelperImplement) {
        return databaseHelperImplement;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperImplement preferencesHelperImplement) {
        return preferencesHelperImplement;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHelperImplement apiHelperImplement) {
        return apiHelperImplement;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           @NonNull PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .build();
    }
}
