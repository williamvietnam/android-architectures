package com.base.mvp.sample.author;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.base.mvp.core.base.MVP.MvpFragmentPresenter;
import com.base.mvp.databinding.FragmentAuthorBinding;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public class AuthorFragment extends MvpFragmentPresenter<
        FragmentAuthorBinding,
        AuthorContract.View,
        AuthorContract.Presenter<AuthorContract.View>>
        implements AuthorContract.View {

    @Override
    public FragmentAuthorBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentAuthorBinding.inflate(inflater, container, false);
    }

    @Override
    public AuthorContract.Presenter<AuthorContract.View> getPresenter() {
        return new AuthorPresenter<>();
    }

    @Override
    public void initialize() {

    }
}
