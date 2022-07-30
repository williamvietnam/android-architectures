package com.base.mvp.core.base;

import androidx.lifecycle.LifecycleObserver;

/**
 * Author: William Giang Nguyen | 25/06/2022
 * */
public interface BaseContractPresenter<V extends BaseContractView> extends LifecycleObserver {
    void attachView(V view);

    boolean isViewAttached();

    V getView();

    void onCreateScreen();

    void onDestroyScreen();
}
