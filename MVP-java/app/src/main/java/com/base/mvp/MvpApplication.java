package com.base.mvp;

import androidx.multidex.MultiDexApplication;

import com.base.mvp.core.di.component.ApplicationComponent;
import com.base.mvp.core.di.component.DaggerApplicationComponent;
import com.base.mvp.core.di.module.ApplicationModule;

public class MvpApplication extends MultiDexApplication {
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
