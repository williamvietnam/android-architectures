package com.base.mvvm.samples.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.mvvm.MVVMFragment
import com.base.mvvm.databinding.FragmentHomeSampleBinding
import com.base.mvvm.samples.models.Banner

class HomeSampleFragment : MVVMFragment<
        FragmentHomeSampleBinding,
        HomeSampleViewModel>(R.layout.fragment_home_sample), HomeView {

    private val viewModel: HomeSampleViewModel by viewModels()

    override fun getVM(): HomeSampleViewModel = viewModel

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        setupToolbar()
        setupSlideBanner(viewModel.getListBanners())
    }

    private fun setupToolbar() {
        binding.toolbar.setTvTitle("Home")
        binding.toolbar.setRightEnable(enable = true)
        binding.toolbar.setSrcLeft(R.drawable.ic_exit)
    }

    private fun setupSlideBanner(banners: List<Banner>) {
        if (banners != null && banners.isNotEmpty()) {
            binding.viewPagerBanner.visibility = View.VISIBLE
        } else {
            binding.viewPagerBanner.visibility = View.GONE
        }
    }

}