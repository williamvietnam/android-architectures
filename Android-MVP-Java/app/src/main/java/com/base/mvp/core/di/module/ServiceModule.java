package com.base.mvp.core.di.module;

import android.app.Service;

import dagger.Module;

@Module
public class ServiceModule {

    private final Service service;

    public ServiceModule(Service service) {
        this.service = service;
    }
}
