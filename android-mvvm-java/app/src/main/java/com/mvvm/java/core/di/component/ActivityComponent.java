package com.mvvm.java.core.di.component;

import com.mvvm.java.core.di.PerActivity;
import com.mvvm.java.core.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

}
