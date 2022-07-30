package com.base.mvp.sample.main;

import com.base.mvp.core.base.MVP.MvpActivityPresenter;
import com.base.mvp.databinding.ActivityMainBinding;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public class MainActivity extends MvpActivityPresenter<
        ActivityMainBinding,
        MainContract.View,
        MainContract.Presenter<MainContract.View>>
        implements MainContract.View {

    @Override
    public ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public MainContract.Presenter<MainContract.View> getPresenter() {
        return new MainPresenter<>();
    }

    @Override
    public void initialize() {
        //todo
    }
}
