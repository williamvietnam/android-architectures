package com.base.mvvm.core.baseMVVM

import androidx.annotation.StringRes
import com.base.mvvm.R

interface MvvmActivityView {

    fun initialize()

    fun showProgressDialog(isShow: Boolean)

    fun showDialogInfo(
        @StringRes titleId: Int = R.string.notification, @StringRes messageId: Int,
        cancel: (() -> Unit)? = null,
        close: (() -> Unit)? = null,
        dismissClickOutSide: Boolean = false
    )

    fun showWarningDialog(msg: String)

    fun showWarningDialog(resId: Int)
}