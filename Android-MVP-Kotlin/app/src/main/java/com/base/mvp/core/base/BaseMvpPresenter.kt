package com.base.mvp.core.base

import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseMvpPresenter<V : BaseContractView> : BaseContractPresenter<V> {

    private val mCompositeDisposable: CompositeDisposable? = null

    private lateinit var view: V

    override fun onAttachView(view: V) {
        this.view = view
    }


    override fun getView(): V {
        return this.view
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    fun isViewAttached(): Boolean {
        return view != null
    }

    class MvpViewNotAttachedException : RuntimeException(
        "Please call Presenter.onAttach(MvpView) before" +
                " requesting data to the Presenter"
    )

}