package com.mvvm.java.core.di.component;

import com.mvvm.java.core.di.PerActivity;
import com.mvvm.java.core.di.module.ServiceModule;

import dagger.Component;

/**
 * hence they need to be in same scope (@PerActivity)
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceActivityComponent {

}
