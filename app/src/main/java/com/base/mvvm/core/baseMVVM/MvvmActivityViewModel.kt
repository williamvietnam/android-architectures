package com.base.mvvm.core.baseMVVM

import android.os.Bundle
import androidx.viewbinding.ViewBinding

abstract class MvvmActivityViewModel<
        VB : ViewBinding,
        VM : MvvmViewModel<*>>
    : MvvmActivity<VB>(), MvvmActivityView {

    private lateinit var viewModel: VM

    abstract fun getViewModel(): VM

    abstract fun getBindingVariable(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
    }
}