package com.base.mvvm.samples.navigation

import android.os.Bundle
import com.base.mvvm.core.navigationComponent.BaseNavigator

interface SampleNavigator : BaseNavigator {

    fun openSplashToHomeScreen(bundle: Bundle? = null)

    fun openHomeToBannerDetail(bundle: Bundle? = null)

}