package com.base.mvvm.core.base.mvvm

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.base.mvvm.core.base.BaseMVVMActivity
import com.base.mvvm.core.base.BaseViewModel

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
abstract class MVVMActivity<BD : ViewDataBinding, VM : BaseViewModel> :
    BaseMVVMActivity<BD>() {

    private lateinit var viewModel: VM

    abstract fun getVM(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getVM()
    }

}