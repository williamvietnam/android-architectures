package com.base.mvp.sample.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.base.mvp.core.base.MVP_v2.MvpActivityDI;
import com.base.mvp.databinding.ActivityMainBinding;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public class MainActivity extends MvpActivityDI<
        ActivityMainBinding,
        MainContract.View,
        MainContract.Presenter<MainContract.View>>
        implements MainContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivityComponent() != null) {
            getActivityComponent().inject(this);
            presenter.onAttachView(this);
        }
    }

    @Override
    public ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initialize() {
        //todo
    }
}
