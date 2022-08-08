package com.base.mvvm.samples.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.base.mvvm.R
import com.base.mvvm.core.base.BaseFragmentViewModel
import com.base.mvvm.databinding.FragmentHomeSampleBinding
import com.base.mvvm.samples.models.Banner
import com.base.mvvm.samples.models.Story
import com.base.mvvm.samples.navigation.SampleNavigator
import com.base.mvvm.samples.ui.home.adapters.BannerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeSampleFragment : BaseFragmentViewModel<
        FragmentHomeSampleBinding,
        HomeSampleViewModel>(R.layout.fragment_home_sample), HomeView, BannerAdapter.CallBack {

    @Inject
    lateinit var navigation: SampleNavigator

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

    private fun setupStories(stories: List<Story>) {

    }

    private fun setupSlideBanner(banners: List<Banner>?) {
        if (banners != null && banners.isNotEmpty()) {
            binding.viewPagerBanner.visibility = View.VISIBLE
            binding.viewPagerBanner.adapter = BannerAdapter(banners = banners, this)
            binding.viewPagerBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        } else {
            binding.viewPagerBanner.visibility = View.GONE
        }
    }

    override fun condition(position: Int, fullSize: Int) {

    }

    override fun onClick(item: Banner) {
        val args = Bundle()
        args.putInt("bannerId", item.bannerId)
        findNavController().navigate(R.id.actionHomeToBanner, args)
    }
}