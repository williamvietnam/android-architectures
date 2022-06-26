package com.base.mvvm.core.baseMVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.base.mvvm.core.utils.LoadingState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class MvvmViewModel<V> : ViewModel() {

    val disposables = CompositeDisposable()

    private var view: WeakReference<V>? = null

    private var loadingStateLiveData = MutableLiveData<LoadingState>(LoadingState.IDLE)

    fun getView(): V? {
        return this.view?.get()
    }

    fun setView(view: V) {
        this.view = WeakReference(view)
    }

    fun getLoadingState(): LiveData<LoadingState> = this.loadingStateLiveData

    fun setLoadingState(loadingState: LoadingState) {
        this.loadingStateLiveData.value = loadingState
    }
}