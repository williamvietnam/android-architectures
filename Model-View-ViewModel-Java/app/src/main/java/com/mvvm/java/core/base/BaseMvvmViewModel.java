package com.mvvm.java.core.base;

import androidx.lifecycle.ViewModel;

import com.mvvm.java.core.data.DataManager;
import com.mvvm.java.core.utilities.rx.SchedulerProvider;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BaseMvvmViewModel extends ViewModel {

    private static final String TAG = "BaseMvvmViewModel";
    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;

    public BaseMvvmViewModel(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
    }

    public DataManager getDataManager() {
        return this.dataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return this.schedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }
}