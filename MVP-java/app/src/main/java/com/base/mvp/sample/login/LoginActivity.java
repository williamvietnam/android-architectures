package com.base.mvp.sample.login;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.base.mvp.core.base.MVP.MvpActivityPresenter;
import com.base.mvp.core.base.MVP_v2.MvpActivityDI;
import com.base.mvp.databinding.ActivityLoginBinding;

public class LoginActivity extends MvpActivityDI<
        ActivityLoginBinding,
        LoginContract.View,
        LoginContract.Presenter<LoginContract.View>>
        implements LoginContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getActivityComponent()!=null){
            getActivityComponent().inject(this);
            presenter.onAttachView(this);
        }
    }

    @Override
    public ActivityLoginBinding getViewBinding() {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initialize() {
        //todo
    }
}
