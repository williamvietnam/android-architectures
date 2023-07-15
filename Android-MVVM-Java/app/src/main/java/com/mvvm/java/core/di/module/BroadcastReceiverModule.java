package com.mvvm.java.core.di.module;

import android.content.BroadcastReceiver;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@Module
public class BroadcastReceiverModule {

    private final BroadcastReceiver receiver;


    public BroadcastReceiverModule(BroadcastReceiver receiver) {
        this.receiver = receiver;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

//    @Provides
//    SchedulerProvider provideSchedulerProvider() {
//        return new SchedulerProviderImpl();
//    }

}
