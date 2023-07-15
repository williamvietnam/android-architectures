package com.mvvm.java.core.base;

import androidx.annotation.StringRes;

public interface BaseMvvmView {

    void setup();

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

}