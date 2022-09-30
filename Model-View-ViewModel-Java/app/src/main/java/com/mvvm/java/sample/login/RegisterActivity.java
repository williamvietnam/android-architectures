package com.mvvm.java.sample.login;

import com.mvvm.java.core.base.mvvm.MVVMActivity;
import com.mvvm.java.core.di.component.ActivityComponent;
import com.mvvm.java.databinding.ActivityRegisterBinding;

public class RegisterActivity extends MVVMActivity<ActivityRegisterBinding, RegisterViewModel> {

    @Override
    public ActivityRegisterBinding createViewBinding() {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
        }
        return ActivityRegisterBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setup() {

    }
}