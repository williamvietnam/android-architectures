package com.mvvm.java.core.base.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.mvvm.java.core.base.BaseMvvmFragment;
import com.mvvm.java.core.base.BaseMvvmView;
import com.mvvm.java.core.base.BaseMvvmViewModel;

import javax.inject.Inject;

public abstract class MVVMFragment<VB extends ViewBinding, VM extends BaseMvvmViewModel>
        extends BaseMvvmFragment<VB> implements BaseMvvmView {

    @Inject
    public VM viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
