package com.base.mvvm.core.module

import com.base.mvvm.core.data.preferences.AppPreferences
import com.base.mvvm.core.data.preferences.RxPreferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SharedPrefsModule {

    @Binds
    @Singleton
    abstract fun provideRxPreference(preferences: AppPreferences): RxPreferences
}