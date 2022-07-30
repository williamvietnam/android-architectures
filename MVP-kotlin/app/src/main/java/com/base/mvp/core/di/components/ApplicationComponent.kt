package com.base.mvp.core.di.components

import android.app.Application
import android.content.Context
import com.base.mvp.MVPApplication
import com.base.mvp.core.di.ApplicationContext
import com.base.mvp.core.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: MVPApplication?)

    @ApplicationContext
    fun context(): Context?

    fun application(): Application?
}