package com.base.mvp.core.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import com.base.mvp.core.custom.CustomDialog;
import com.base.mvp.core.utilities.Constants;
import com.base.mvp.core.utilities.Utilities;

import timber.log.Timber;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public abstract class BaseMvpFragment<VB extends ViewBinding>
        extends Fragment implements BaseContractView {

    public VB binding;
    private BaseMvpActivity<VB> activity;
    private static Dialog progressDialog;
    private static boolean isLoading;
    protected NavController mNavController = null;

    public abstract VB getViewBinding(LayoutInflater inflater, ViewGroup container);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = getViewBinding(inflater, container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    public NavController findNavController() {
        return Navigation.findNavController(binding.getRoot());
    }

    @Override
    public void showLoading() {
        hideLoading();
        final Context context = getContext();
        if (context != null) {
            synchronized (BaseMvpFragment.this) {
                isLoading = true;
                progressDialog = CustomDialog.showLoadingDialog(getContext());
                Timber.tag(Constants.TAG_MVP_FRAGMENT).d("showLoadingDialog");
                new Handler(Looper.getMainLooper()).post(() -> progressDialog.show());
            }
        } else {
            Timber.tag(Constants.TAG_MVP_FRAGMENT).d("#showLoading() context maybe null");
        }
    }

    @Override
    public void hideLoading() {
        if (Utilities.isForegroundApp(requireContext())) {
            try {
                synchronized (BaseMvpFragment.this) {
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.cancel();
                        progressDialog = null;
                        // reset loading flag
                        isLoading = false;
                    }
                }
            } catch (Exception exception) {
                // something occurs error when dismiss dialog
                Timber.tag(Constants.TAG_MVP_FRAGMENT).d(exception);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        if (activity != null) {
            activity.showMessage(message);
        }
    }

    @Override
    public void showMessage(int resId) {
        if (activity != null) {
            activity.showMessage(resId);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (activity != null) {
            return activity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void hideKeyboard() {
        if (activity != null) {
            activity.hideKeyboard();
        }
    }
}
