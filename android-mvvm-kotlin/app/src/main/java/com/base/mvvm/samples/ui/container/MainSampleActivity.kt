package com.base.mvvm.samples.ui.container

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.base.mvvm.R
import com.base.mvvm.core.base.mvvm.MVVMActivity
import com.base.mvvm.databinding.ActivityMainSampleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainSampleActivity : MVVMActivity<ActivityMainSampleBinding, MainSampleViewModel>() {

//    @Inject
//    lateinit var appNavigation: SampleNavigator

    private val viewModel: MainSampleViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.activity_main_sample

    override fun getVM(): MainSampleViewModel = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment?

//        appNavigation.bind(navHostFragment.navController)
        val navController = navHostFragment?.navController
        if (navController != null) {
            binding.bottomNav.setupWithNavController(navController)
        }
    }
}