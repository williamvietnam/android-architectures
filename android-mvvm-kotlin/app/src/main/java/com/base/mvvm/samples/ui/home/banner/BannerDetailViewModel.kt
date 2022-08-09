package com.base.mvvm.samples.ui.home.banner

import com.base.mvvm.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BannerDetailViewModel @Inject constructor(): BaseViewModel() {
    init {
        Timber.tag("BannerDetailViewModel()...")
    }
}