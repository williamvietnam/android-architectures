package com.base.mvp.core.di.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.base.mvp.core.di.ActivityContext
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Author: William Giang Nguyen | 7/7/2022
 * */
@Module
class ActivityModule {

    private var activity: AppCompatActivity? = null

    fun ActivityModule(activity: AppCompatActivity?) {
        this.activity = activity
    }

    @Provides
    @ActivityContext
    fun provideContext(): Context? {
        return activity
    }

    @Provides
    fun provideActivity(): AppCompatActivity? {
        return activity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable? {
        return CompositeDisposable()
    }
}