package com.base.mvvm.core.base

import android.os.Bundle
import android.text.TextUtils
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
abstract class BaseFragmentViewModel<
        BD : ViewDataBinding,
        VM : BaseViewModel>(
    @LayoutRes id: Int
) : BaseFragment<BD>(id) {

    private lateinit var viewModel: VM

    abstract fun getVM(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getVM()
    }

    override fun initView(savedInstanceState: Bundle?) {
        with(viewModel) {
            messageError.observe(viewLifecycleOwner) {
                var message = ""
                if (it is String) {
                    message = it
                } else {
                    if (it is Int) {
                        try {
                            message = getString(it)
                        } catch (e: Exception) {
                            //do nothing
                        }
                    }
                }
                if (!TextUtils.isEmpty(message)) {
                    showAlertDialog(message)
                }
            }
            isLoading.observe(viewLifecycleOwner) {
                showHideLoading(it)
            }
        }
    }
}