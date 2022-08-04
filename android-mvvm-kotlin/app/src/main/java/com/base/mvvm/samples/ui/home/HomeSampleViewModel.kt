package com.base.mvvm.samples.ui.home

import com.base.mvvm.core.base.BaseViewModel
import com.base.mvvm.samples.models.Banner
import timber.log.Timber

class HomeSampleViewModel : BaseViewModel() {

    init {
        Timber.tag("HomeSampleViewModel")
    }

    fun getListBanners(): List<Banner> {


        val banner1 = Banner("", "")
        val banner2 = Banner("", "")
        val banner3 = Banner("", "")
        val banners: List<Banner> = listOf(banner1, banner2, banner3)

        return banners
    }
}