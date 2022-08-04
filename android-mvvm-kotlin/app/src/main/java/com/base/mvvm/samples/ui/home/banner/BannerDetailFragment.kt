package com.base.mvvm.samples.ui.home.banner

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.mvvm.MVVMFragment
import com.base.mvvm.databinding.FragmentBannerDetailBinding

class BannerDetailFragment :
    MVVMFragment<FragmentBannerDetailBinding, BannerDetailViewModel>(R.layout.fragment_banner_detail) {

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