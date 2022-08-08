package com.base.mvvm.samples.ui.splash

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.mvvm.MVVMFragment
import com.base.mvvm.databinding.FragmentSplashBinding
import com.base.mvvm.samples.navigation.SampleNavigator
import com.base.mvvm.samples.navigation.SampleNavigatorImpl
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : MVVMFragment<
        FragmentSplashBinding,
        SplashViewModel>(
    R.layout.fragment_splash
) {

    @Inject
    lateinit var appNavigation: SampleNavigator

    private val viewModel: SplashViewModel by viewModels()

    override fun getVM(): SplashViewModel = viewModel

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        Timber.tag("Debug: Splash onCreated")
    }
}