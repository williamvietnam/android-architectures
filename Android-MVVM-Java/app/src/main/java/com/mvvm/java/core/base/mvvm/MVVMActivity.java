package com.mvvm.java.core.base.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.mvvm.java.core.base.BaseApplication;
import com.mvvm.java.core.base.BaseMvvmActivity;
import com.mvvm.java.core.base.BaseMvvmView;
import com.mvvm.java.core.base.BaseMvvmViewModel;
import com.mvvm.java.core.di.component.ActivityComponent;
import com.mvvm.java.core.di.component.DaggerActivityComponent;
import com.mvvm.java.core.di.module.ActivityModule;

import javax.inject.Inject;

public abstract class MVVMActivity<VB extends ViewBinding, VM extends BaseMvvmViewModel>
        extends BaseMvvmActivity<VB> implements BaseMvvmView {

    @Inject
    public VM viewModel;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((BaseApplication) getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}