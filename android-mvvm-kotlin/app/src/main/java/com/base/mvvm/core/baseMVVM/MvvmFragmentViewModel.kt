package com.base.mvvm.core.baseMVVM

import android.content.Context
import android.os.Bundle
import androidx.viewbinding.ViewBinding

abstract class MvvmFragmentViewModel<
        VB : ViewBinding,
        VM : MvvmViewModel<*>>
    : MvvmFragment<VB>(), MvvmFragmentView {

    private var baseActivity: MvvmActivityViewModel<*, *>? = null
    private lateinit var viewModel: VM

    abstract fun getViewModel(): VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MvvmActivityViewModel<*, *>) {
            this.baseActivity = context
        }
    }

    override fun onDetach() {
        this.baseActivity = null
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = this.getViewModel()
    }
}