package com.base.mvp.sample.splash;

import android.annotation.SuppressLint;

import com.base.mvp.core.base.MVP_v2.MvpActivityDI;
import com.base.mvp.databinding.ActivitySplashBinding;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends MvpActivityDI<ActivitySplashBinding, SplashContract.View, SplashContract.Presenter<SplashContract.View>> {

    @Override
    public ActivitySplashBinding getViewBinding() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initialize() {
        //todo
    }
}
