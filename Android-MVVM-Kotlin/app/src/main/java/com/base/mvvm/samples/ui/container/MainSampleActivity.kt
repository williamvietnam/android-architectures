package com.base.mvvm.samples.ui.container

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.base.mvvm.R
import com.base.mvvm.core.base.BaseActivityViewModel
import com.base.mvvm.databinding.ActivityMainSampleBinding
import com.base.mvvm.samples.navigation.SampleNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainSampleActivity : BaseActivityViewModel<ActivityMainSampleBinding, MainSampleViewModel>() {

    @Inject
    lateinit var appNavigation: SampleNavigator

    private val viewModel: MainSampleViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.activity_main_sample

    override fun createViewModel(): MainSampleViewModel = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        appNavigation.bind(navHostFragment.navController)
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
    }
}