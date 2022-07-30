package com.base.mvp.core.base;

import androidx.annotation.StringRes;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public interface BaseContractView {

    void initialize();

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();
}
