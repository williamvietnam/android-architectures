package com.mvvm.java.core.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.mvvm.java.core.di.ActivityContext;
import com.mvvm.java.core.di.PerActivity;
import com.mvvm.java.core.utilities.rx.SchedulerProvider;
import com.mvvm.java.core.utilities.rx.SchedulerProviderImplement;
import com.mvvm.java.sample.container.MainViewModel;
import com.mvvm.java.sample.login.LoginViewModel;
import com.mvvm.java.sample.login.RegisterViewModel;
import com.mvvm.java.sample.splash.SplashViewModel;
import com.mvvm.java.sample.welcome.WelcomeViewModel;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new SchedulerProviderImplement();
    }

    @Provides
    @PerActivity
    SplashViewModel provideSplashViewModel() {
        return new ViewModelProvider(activity).get(SplashViewModel.class);
    }

    @Provides
    @PerActivity
    WelcomeViewModel provideWelcomeViewModel() {
        return new ViewModelProvider(activity).get(WelcomeViewModel.class);
    }

    @Provides
    @PerActivity
    LoginViewModel provideLoginViewModel() {
        return new ViewModelProvider(activity).get(LoginViewModel.class);
    }

    @Provides
    @PerActivity
    RegisterViewModel provideRegisterViewModel() {
        return new ViewModelProvider(activity).get(RegisterViewModel.class);
    }

    @Provides
    @PerActivity
    MainViewModel provideMainViewModel() {
        return new ViewModelProvider(activity).get(MainViewModel.class);
    }
}