package com.base.mvp.core.di.component;

import com.base.mvp.core.di.PerActivity;
import com.base.mvp.core.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

}
