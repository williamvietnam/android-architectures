package com.base.mvvm.core.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
abstract class BaseActivityViewModel<BD : ViewDataBinding, VM : BaseViewModel> :
    BaseActivity<BD>() {

    private lateinit var viewModel: VM

    abstract fun createViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = createViewModel()
    }

}