package com.base.mvvm.samples.ui.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.BaseActivityViewModel
import com.base.mvvm.databinding.ActivitySplashBinding
import com.base.mvvm.samples.ui.container.MainSampleActivity
import com.base.mvvm.samples.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashSampleActivity() : BaseActivityViewModel<ActivitySplashBinding, SplashViewModel>() {

    private val viewModel: SplashViewModel by viewModels()

    override fun getVM(): SplashViewModel = viewModel

    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            Runnable {
                decideNextScreen(viewModel.decideNextScreen())
            }
        }, 2000)
    }

    override fun onDestroy() {
        finish()
        super.onDestroy()
    }

    private fun decideNextScreen(screen: String) {
        when (screen) {
            MAIN_SCREEN -> openMainScreen()
            LOGIN_SCREEN -> openLoginScreen()
        }
    }

    private fun openLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun openMainScreen() {
        val intent = Intent(this, MainSampleActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val MAIN_SCREEN = "MAIN_SCREEN"
        const val LOGIN_SCREEN = "LOGIN_SCREEN"
    }
}