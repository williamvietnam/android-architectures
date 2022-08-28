package com.base.mvvm.samples.di

import com.base.mvvm.core.navigationComponent.BaseNavigator
import com.base.mvvm.samples.navigation.SampleNavigator
import com.base.mvvm.samples.navigation.SampleNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {
    @Binds
    @ActivityScoped
    abstract fun provideBaseNavigation(navigation: SampleNavigatorImpl): BaseNavigator

    @Binds
    @ActivityScoped
    abstract fun provideSampleNavigator(navigation: SampleNavigatorImpl): SampleNavigator

}