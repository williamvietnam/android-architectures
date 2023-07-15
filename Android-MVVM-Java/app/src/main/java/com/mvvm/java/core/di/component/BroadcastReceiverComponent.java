package com.mvvm.java.core.di.component;

import com.mvvm.java.core.di.PerBroadcastReceiver;
import com.mvvm.java.core.di.module.BroadcastReceiverModule;

import dagger.Component;

@PerBroadcastReceiver
@Component(dependencies = ApplicationComponent.class, modules = BroadcastReceiverModule.class)
public interface BroadcastReceiverComponent {

}