package com.base.mvvm.samples.ui.login

import androidx.activity.viewModels
import com.base.mvvm.R
import com.base.mvvm.core.base.BaseActivityViewModel
import com.base.mvvm.databinding.ActivityLoginBinding

class LoginActivity : BaseActivityViewModel<ActivityLoginBinding, LoginViewModel>() {

    private val viewModel: LoginViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.activity_login

    override fun createViewModel(): LoginViewModel = viewModel


}