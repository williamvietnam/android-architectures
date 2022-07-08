package com.mvvm.java.core.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseMvvmActivity<VB extends ViewBinding>
        extends AppCompatActivity implements BaseMvvmView {

    public VB viewBinding;

    public abstract VB getViewBinding();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = getViewBinding();
        setContentView(viewBinding.getRoot());

        setup();
    }


}
