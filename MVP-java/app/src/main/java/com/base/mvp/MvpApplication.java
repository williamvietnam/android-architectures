package com.base.mvp;

import androidx.multidex.MultiDexApplication;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.di.component.ApplicationComponent;
import com.base.mvp.core.di.component.DaggerApplicationComponent;
import com.base.mvp.core.di.module.ApplicationModule;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MvpApplication extends MultiDexApplication {
    @Inject
    DataManager dataManager;

    @Inject
    CalligraphyConfig calligraphyConfig;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        this.applicationComponent.inject(this);

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        CalligraphyConfig.initDefault(calligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return this.applicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
