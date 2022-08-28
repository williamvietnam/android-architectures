package com.base.mvvm.core.module

import com.base.mvvm.core.data.preferences.PreferencesImplement
import com.base.mvvm.core.data.preferences.RxPreferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
@Module
@InstallIn(SingletonComponent::class)
abstract class SharedPrefsModule {

    @Binds
    @Singleton
    abstract fun provideRxPreference(preferences: PreferencesImplement): RxPreferences
}