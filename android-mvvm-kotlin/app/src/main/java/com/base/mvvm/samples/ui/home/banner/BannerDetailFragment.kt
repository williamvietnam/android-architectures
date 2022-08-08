package com.base.mvvm.samples.ui.home.banner

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.BaseFragmentViewModel
import com.base.mvvm.databinding.FragmentBannerDetailBinding
import com.base.mvvm.samples.navigation.SampleNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BannerDetailFragment :
    BaseFragmentViewModel<FragmentBannerDetailBinding, BannerDetailViewModel>(R.layout.fragment_banner_detail) {

    @Inject
    lateinit var navigation: SampleNavigator

    private var bannerId: Int? = null
    private val viewModel: BannerDetailViewModel by viewModels()

    override fun getVM(): BannerDetailViewModel {
        return viewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val args = Bundle()
        bannerId = args.getInt("bannerId")
    }
}