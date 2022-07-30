package com.base.mvp.core.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.base.mvp.core.di.ActivityContext;
import com.base.mvp.core.utilities.rx.SchedulerProvider;
import com.base.mvp.core.utilities.rx.SchedulerProviderImpl;

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
        return new SchedulerProviderImpl();
    }

}
