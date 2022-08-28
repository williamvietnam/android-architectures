package com.base.mvp.core.di.component;

import com.base.mvp.core.di.PerBroadcastReceiver;
import com.base.mvp.core.di.module.BroadcastReceiverModule;

import dagger.Component;

@PerBroadcastReceiver
@Component(dependencies = ApplicationComponent.class, modules = BroadcastReceiverModule.class)
public interface BroadcastReceiverComponent {

}