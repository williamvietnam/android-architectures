package com.mvvm.java.sample.splash;

import android.annotation.SuppressLint;

import com.mvvm.java.core.base.mvvm.MVVMActivity;
import com.mvvm.java.core.di.component.ActivityComponent;
import com.mvvm.java.databinding.ActivitySplashBinding;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends MVVMActivity<ActivitySplashBinding, SplashViewModel> {

    @Override
    public ActivitySplashBinding createViewBinding() {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
        }
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setup() {

    }
}
