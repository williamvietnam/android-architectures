package com.mvvm.java.core.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.mvvm.java.core.di.ActivityContext;
import com.mvvm.java.core.utilities.rx.SchedulerProvider;
import com.mvvm.java.core.utilities.rx.SchedulerProviderImplement;

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
}