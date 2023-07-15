package com.mvvm.java.sample.author;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mvvm.java.core.base.mvvm.MVVMFragment;
import com.mvvm.java.databinding.FragmentAuthorBinding;

public class AuthorFragment extends MVVMFragment<FragmentAuthorBinding, AuthorViewModel> {

    @Override
    public FragmentAuthorBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup container) {
        return FragmentAuthorBinding.inflate(layoutInflater, container, false);
    }

    @Override
    public void setup() {

    }
}