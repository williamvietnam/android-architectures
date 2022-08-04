package com.base.mvvm.core

import android.app.Application
import timber.log.Timber

abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.d("BaseApplication()")
    }
}
