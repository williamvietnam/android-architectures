package com.mvvm.java.core.di.component;

import com.mvvm.java.core.di.PerActivity;
import com.mvvm.java.core.di.module.ActivityModule;
import com.mvvm.java.sample.container.MainActivity;
import com.mvvm.java.sample.login.LoginActivity;
import com.mvvm.java.sample.login.RegisterActivity;
import com.mvvm.java.sample.splash.SplashActivity;
import com.mvvm.java.sample.welcome.WelcomeActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);

    void inject(WelcomeActivity activity);

    void inject(LoginActivity activity);

    void inject(RegisterActivity activity);

    void inject(MainActivity activity);
}