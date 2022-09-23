package com.mvvm.java.core.base.mvvm;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.mvvm.java.core.base.BaseMvvmFragment;
import com.mvvm.java.core.base.BaseMvvmView;
import com.mvvm.java.core.base.BaseMvvmViewModel;
import com.mvvm.java.core.di.component.ActivityComponent;

import javax.inject.Inject;

public abstract class MVVMFragment<VB extends ViewBinding, VM extends BaseMvvmViewModel>
        extends BaseMvvmFragment<VB> implements BaseMvvmView {

    @Inject
    public VM viewModel;

    private MVVMActivity<VB, VM> activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MVVMActivity) {
            MVVMActivity<VB, VM> activity = (MVVMActivity<VB, VM>) context;
            this.activity = activity;
        }
    }

    public ActivityComponent getActivityComponent() {
        if (activity != null) {
            return activity.getActivityComponent();
        }
        return null;
    }
}
