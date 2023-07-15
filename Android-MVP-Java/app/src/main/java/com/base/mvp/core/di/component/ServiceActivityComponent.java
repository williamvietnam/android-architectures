package com.base.mvp.core.di.component;

import com.base.mvp.core.di.PerActivity;
import com.base.mvp.core.di.module.ServiceModule;

import dagger.Component;

/*
 * hence they need to be in same scope (@PerActivity)
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceActivityComponent {

}
