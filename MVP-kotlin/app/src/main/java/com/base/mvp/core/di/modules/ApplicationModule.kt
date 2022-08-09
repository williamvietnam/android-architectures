package com.base.mvp.core.di.modules

import android.app.Application
import android.content.Context
import com.base.mvp.core.di.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Author: William Giang Nguyen | 7/7/2022
 * */
@Module
class ApplicationModule {
    private var application: Application? = null

    fun ApplicationModule(application: Application?) {
        this.application = application
    }

    @Provides
    @ApplicationContext
    fun provideContext(): Context? {
        return application
    }

    @Provides
    fun provideApplication(): Application? {
        return application
    }
}