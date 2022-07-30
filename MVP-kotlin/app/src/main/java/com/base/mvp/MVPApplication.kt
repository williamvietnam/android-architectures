package com.base.mvp

import android.app.Application
import com.base.mvp.core.di.components.ApplicationComponent
import com.base.mvp.core.di.modules.ApplicationModule

class MVPApplication: Application() {

    private var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()

        applicationComponent.inject(this)
    }

    fun getComponent(): ApplicationComponent? {
        return applicationComponent
    }

    // Needed to replace the component with a test specific one
    fun setComponent(applicationComponent: ApplicationComponent) {
        this.applicationComponent = applicationComponent
    }
}