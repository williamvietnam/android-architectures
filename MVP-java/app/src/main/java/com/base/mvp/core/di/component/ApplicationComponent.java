package com.base.mvp.core.di.component;

import android.app.Application;
import android.content.Context;

import com.base.mvp.MvpApplication;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.di.ApplicationContext;
import com.base.mvp.core.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApplication app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}