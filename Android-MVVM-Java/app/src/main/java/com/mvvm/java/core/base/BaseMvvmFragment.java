package com.mvvm.java.core.base;

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

import com.mvvm.java.core.custom.CustomDialog;
import com.mvvm.java.core.utilities.Constants;
import com.mvvm.java.core.utilities.Utilities;

public abstract class BaseMvvmFragment<VB extends ViewBinding>
        extends Fragment implements BaseMvvmView {

    public VB binding;

    private BaseMvvmActivity<VB> activity;
    private static Dialog progressDialog;
    private static boolean isLoading;
    protected NavController mNavController = null;

    public abstract VB createViewBinding(LayoutInflater layoutInflater, ViewGroup container);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = createViewBinding(inflater, container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup();
    }

    public NavController findNavController() {
        return Navigation.findNavController(binding.getRoot());
    }

    @Override
    public void showLoading() {
        hideLoading();
        final Context context = getContext();
        if (context != null) {
            synchronized (BaseMvvmFragment.this) {
                isLoading = true;
                progressDialog = CustomDialog.showLoadingDialog(getContext());
                Log.d(Constants.TAG_MVP_FRAGMENT, "showLoadingDialog");
                new Handler(Looper.getMainLooper()).post(() -> progressDialog.show());
            }
        } else {
            Log.d(Constants.TAG_MVP_FRAGMENT, "#showLoading() context maybe null");
        }
    }

    @Override
    public void hideLoading() {
        if (Utilities.isForegroundApp(requireContext())) {
            try {
                synchronized (BaseMvvmFragment.this) {
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.cancel();
                        progressDialog = null;
                        // reset loading flag
                        isLoading = false;
                    }
                }
            } catch (Exception exception) {
                // something occurs error when dismiss dialog
                Log.d(Constants.TAG_MVP_FRAGMENT, exception.getMessage());
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
