package com.base.mvp.sample.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.base.mvp.core.base.MVP.MvpFragmentPresenter;
import com.base.mvp.databinding.FragmentHomeBinding;

public class HomeFragment extends MvpFragmentPresenter<
        FragmentHomeBinding,
        HomeContract.View,
        HomeContract.Presenter<HomeContract.View>>
        implements HomeContract.View {

    @Override
    public FragmentHomeBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }

    @Override
    public HomeContract.Presenter<HomeContract.View> getPresenter() {
        return new HomePresenter<>();
    }

    @Override
    public void initialize() {
        //todo
    }
}
