package com.base.mvvm.samples.navigation

import android.os.Bundle
import com.base.mvvm.R
import com.base.mvvm.core.navigationComponent.BaseNavigatorImpl
import javax.inject.Inject

class SampleNavigatorImpl @Inject constructor() : BaseNavigatorImpl(), SampleNavigator {

    override fun openSplashToHomeScreen(bundle: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun openHomeToBannerDetail(bundle: Bundle?) {
        openScreen(R.id.actionHomeToBanner, bundle)
    }

}