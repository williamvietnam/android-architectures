package com.base.mvvm.samples.ui.author

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.mvvm.MVVMFragment
import com.base.mvvm.databinding.FragmentAuthorSampleBinding
import timber.log.Timber

class AuthorSampleFragment : MVVMFragment<
        FragmentAuthorSampleBinding,
        AuthorSampleViewModel>(R.layout.fragment_author_sample), AuthorSampleView {

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