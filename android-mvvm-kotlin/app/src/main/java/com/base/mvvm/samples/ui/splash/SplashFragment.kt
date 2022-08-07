package com.base.mvvm.samples.ui.splash

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.mvvm.MVVMFragment
import com.base.mvvm.databinding.FragmentSplashBinding
import timber.log.Timber

class SplashFragment : MVVMFragment<
        FragmentSplashBinding,
        SplashViewModel>(
    R.layout.fragment_splash
) {
    private val viewModel: SplashViewModel by viewModels()

    override fun getVM(): SplashViewModel {
        return viewModel
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        Timber.tag("Debug: Splash onCreated")
    }
}