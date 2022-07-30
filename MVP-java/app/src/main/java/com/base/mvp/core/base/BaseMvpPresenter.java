package com.base.mvp.core.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import java.lang.ref.WeakReference;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * Author: William Giang Nguyen | 25/06/2022
 * */
public abstract class BaseMvpPresenter<V extends BaseContractView> implements BaseContractPresenter<V> {
    private WeakReference<V> weakView = null;

    protected CompositeDisposable compositeDisposable;

    @Override
    final public boolean isViewAttached() {
        return weakView != null && weakView.get() != null;
    }

    @Override
    final public V getView() {
        if (weakView != null) {
            return weakView.get();
        }
        return null;
    }

    @Override
    public final void attachView(V view) {
        if (!isViewAttached()) {
            weakView = new WeakReference<>(view);
            compositeDisposable = new CompositeDisposable();
        }
        onCreateScreen();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void detachView() {
        onDestroyScreen();
        weakView.clear();
        weakView = null;
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void onCreateScreen() {
        // handle at child
    }

    @Override
    public void onDestroyScreen() {
        // handle at child
    }
}
