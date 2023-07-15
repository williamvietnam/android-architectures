package com.base.mvp.sample.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.base.mvp.core.base.MVP_v2.MvpFragmentDI;
import com.base.mvp.core.di.component.ActivityComponent;
import com.base.mvp.databinding.FragmentHomeBinding;

public class HomeFragment extends MvpFragmentDI<
        FragmentHomeBinding,
        HomeContract.View,
        HomeContract.Presenter<HomeContract.View>>
        implements HomeContract.View {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            presenter.onAttachView(this);
        }
    }

    @Override
    public FragmentHomeBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }


    @Override
    public void initialize() {
        //todo
    }
}
