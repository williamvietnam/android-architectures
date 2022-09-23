package com.base.mvvm.core.module

import com.base.mvvm.core.data.preferences.PreferencesHelper
import com.base.mvvm.core.data.preferences.PreferencesImplement
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
abstract class PreferencesModule {

    @Binds
    @Singleton
    abstract fun providePreferencesHelper(preferences: PreferencesImplement): PreferencesHelper
}