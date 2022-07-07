package com.base.mvvm.core.base

import android.app.Service
import android.content.Intent
import android.os.IBinder

open class BaseService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}