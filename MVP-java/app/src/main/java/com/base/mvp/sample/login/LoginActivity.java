package com.base.mvp.sample.login;

import com.base.mvp.core.base.MVP.MvpActivityPresenter;
import com.base.mvp.databinding.ActivityLoginBinding;

public class LoginActivity extends MvpActivityPresenter<
        ActivityLoginBinding,
        LoginContract.View,
        LoginContract.Presenter<LoginContract.View>>
        implements LoginContract.View {

    @Override
    public ActivityLoginBinding getViewBinding() {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    public LoginContract.Presenter<LoginContract.View> getPresenter() {
        return new LoginPresenter<>();
    }

    @Override
    public void initialize() {
        //todo
    }
}
