package com.base.mvvm.samples.ui.splash

import com.base.mvvm.core.base.BaseViewModel
import com.base.mvvm.samples.ui.splash.SplashSampleActivity.Companion.LOGIN_SCREEN
import com.base.mvvm.samples.ui.splash.SplashSampleActivity.Companion.MAIN_SCREEN
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    private var isLogin: Boolean = false

    fun decideNextScreen(): String {
        if (!isLogin) {
            isLogin = true
            return LOGIN_SCREEN
        }
        return MAIN_SCREEN
    }
}