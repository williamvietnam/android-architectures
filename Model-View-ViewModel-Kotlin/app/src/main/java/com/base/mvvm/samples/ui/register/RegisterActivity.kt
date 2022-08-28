package com.base.mvvm.samples.ui.register

import androidx.activity.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.BaseActivityViewModel
import com.base.mvvm.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivityViewModel<ActivityRegisterBinding, RegisterViewModel>() {

    private val viewModel: RegisterViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.activity_register

    override fun getVM(): RegisterViewModel = viewModel
}