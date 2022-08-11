package com.base.mvp.core.base;

import androidx.lifecycle.LifecycleObserver;

import com.androidnetworking.error.ANError;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.utilities.rx.SchedulerProvider;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public interface BaseContractPresenter<V extends BaseContractView> extends LifecycleObserver {

    void onAttachView(V view);

    void onDetach();

    boolean isViewAttached();

    void checkViewAttached();

    V getView();

    DataManager getDataManager();

    SchedulerProvider getSchedulerProvider();

    CompositeDisposable getCompositeDisposable();

    void setUserAsLoggedOut();

    void handleApiError(ANError error);

    void onCreateScreen();

    void onDestroyScreen();
}
