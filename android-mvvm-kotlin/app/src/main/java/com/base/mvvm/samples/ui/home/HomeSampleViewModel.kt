package com.base.mvvm.samples.ui.home

import com.base.mvvm.core.base.BaseViewModel
import com.base.mvvm.samples.models.Banner
import com.base.mvvm.samples.models.Story
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeSampleViewModel @Inject constructor() : BaseViewModel() {

    init {
        Timber.tag("HomeSampleViewModel")
    }

    fun getListStories(): List<Story>? {
        return null
    }

    fun getListBanners(): List<Banner>? {


//        val banner1 = Banner(0, "", "")
//        val banner2 = Banner(1, "", "")
//        val banner3 = Banner(2, "", "")
//        val banners: List<Banner> = listOf(banner1, banner2, banner3)

        return null
    }
}