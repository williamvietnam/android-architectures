package com.mvvm.java.core.di.component;

import android.app.Application;
import android.content.Context;

import com.mvvm.java.core.base.BaseApplication;
import com.mvvm.java.core.di.ApplicationContext;
import com.mvvm.java.core.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseApplication app);

    @ApplicationContext
    Context context();

    Application application();
}