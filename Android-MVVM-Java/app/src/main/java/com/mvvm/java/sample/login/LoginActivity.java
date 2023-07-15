package com.mvvm.java.sample.login;

import com.mvvm.java.core.base.mvvm.MVVMActivity;
import com.mvvm.java.core.di.component.ActivityComponent;
import com.mvvm.java.databinding.ActivityLoginBinding;

public class LoginActivity extends MVVMActivity<ActivityLoginBinding, LoginViewModel> {
    @Override
    public ActivityLoginBinding createViewBinding() {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
        }
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setup() {

    }
}
