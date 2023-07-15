package com.mvvm.java.core.base;

import androidx.multidex.MultiDexApplication;

import com.mvvm.java.core.di.component.ApplicationComponent;
import com.mvvm.java.core.di.component.DaggerApplicationComponent;
import com.mvvm.java.core.di.module.ApplicationModule;

public class BaseApplication extends MultiDexApplication {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
