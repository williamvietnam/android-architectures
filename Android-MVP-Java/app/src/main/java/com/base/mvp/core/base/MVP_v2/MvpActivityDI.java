package com.base.mvp.core.base.MVP_v2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.base.mvp.MvpApplication;
import com.base.mvp.core.base.BaseContractPresenter;
import com.base.mvp.core.base.BaseContractView;
import com.base.mvp.core.base.BaseMvpActivity;
import com.base.mvp.core.di.component.ActivityComponent;
import com.base.mvp.core.di.component.DaggerActivityComponent;
import com.base.mvp.core.di.module.ActivityModule;

import javax.inject.Inject;

public abstract class MvpActivityDI<
        VB extends ViewBinding,
        V extends BaseContractView,
        P extends BaseContractPresenter<V>>
        extends BaseMvpActivity<VB> implements BaseContractView {

    @Inject
    public P presenter;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApplication) getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}