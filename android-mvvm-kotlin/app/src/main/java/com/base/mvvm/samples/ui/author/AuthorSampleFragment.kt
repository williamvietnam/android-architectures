package com.base.mvvm.samples.ui.author

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.mvvm.MVVMFragment
import com.base.mvvm.databinding.FragmentAuthorSampleBinding
import com.base.mvvm.samples.navigation.SampleNavigator
import com.base.mvvm.samples.navigation.SampleNavigatorImpl
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class AuthorSampleFragment : MVVMFragment<
        FragmentAuthorSampleBinding,
        AuthorSampleViewModel>(R.layout.fragment_author_sample), AuthorSampleView {

    @Inject
    lateinit var navigation: SampleNavigator

    private val viewModel: AuthorSampleViewModel by viewModels()

    override fun getVM(): AuthorSampleViewModel {
        return viewModel
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        //TODO
        Timber.tag("")
    }

}