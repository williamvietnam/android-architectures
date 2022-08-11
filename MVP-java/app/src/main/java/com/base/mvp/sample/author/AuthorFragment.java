package com.base.mvp.sample.author;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.base.mvp.core.base.MVP_v2.MvpFragmentDI;
import com.base.mvp.core.di.component.ActivityComponent;
import com.base.mvp.databinding.FragmentAuthorBinding;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public class AuthorFragment extends MvpFragmentDI<
        FragmentAuthorBinding,
        AuthorContract.View,
        AuthorContract.Presenter<AuthorContract.View>>
        implements AuthorContract.View {

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
    public FragmentAuthorBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentAuthorBinding.inflate(inflater, container, false);
    }

    @Override
    public void initialize() {

    }
}
