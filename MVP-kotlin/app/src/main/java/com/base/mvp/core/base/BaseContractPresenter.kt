package com.base.mvp.core.base

interface BaseContractPresenter<V: BaseContractView> {
    fun onAttachView(view: V)

    fun getView(): V
}