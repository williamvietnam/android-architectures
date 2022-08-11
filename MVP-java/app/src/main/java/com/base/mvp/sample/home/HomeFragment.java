package com.base.mvp.sample.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.base.mvp.core.base.MVP_v2.MvpFragmentDI;
import com.base.mvp.databinding.FragmentHomeBinding;

public class HomeFragment extends MvpFragmentDI<
        FragmentHomeBinding,
        HomeContract.View,
        HomeContract.Presenter<HomeContract.View>>
        implements HomeContract.View {


    @Override
    public FragmentHomeBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        if (getActivityComponent() != null) {
            getActivityComponent().inject(this);
            presenter.onAttachView(this);
        }
        return FragmentHomeBinding.inflate(inflater, container, false);
    }


    @Override
    public void initialize() {
        //todo
    }
}
