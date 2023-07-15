package com.base.mvp.core.utilities.rx;

import java.util.concurrent.Executor;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchedulerProviderImpl implements SchedulerProvider {
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler newThread() {
        return Schedulers.newThread();
    }

    @Override
    public Scheduler single() {
        return Schedulers.single();
    }

    @Override
    public Scheduler immediate() {
        return null;
    }

    @Override
    public Scheduler trampoline() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler from(Executor executor) {
        return Schedulers.from(executor);
    }
}
