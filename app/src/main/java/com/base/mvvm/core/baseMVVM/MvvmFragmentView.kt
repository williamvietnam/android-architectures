package com.base.mvvm.core.baseMVVM

interface MvvmFragmentView {
    fun initialize()

    fun screenBack()

    fun showProgressDialog(isShow: Boolean)

    fun showSnackBar(message: String)

    fun showSnackBar(resId: Int)

    fun showWarningDialog(msg: String)

    fun showWarningDialog(resId: Int)

    fun showErrorPopup(resTitleId: Int, resContentId : Int)

    fun showConfirmPopup(resTitleId: Int, resContentId: Int?, completion: ()-> Unit)

}