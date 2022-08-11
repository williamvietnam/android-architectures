package com.base.mvp.sample.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.base.mvp.core.base.MVP_v2.MvpActivityDI;
import com.base.mvp.core.di.component.ActivityComponent;
import com.base.mvp.databinding.ActivitySplashBinding;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends MvpActivityDI<
        ActivitySplashBinding,
        SplashContract.View,
        SplashContract.Presenter<SplashContract.View>>
        implements SplashContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            presenter.onAttachView(this);
        }
    }

    @Override
    public ActivitySplashBinding getViewBinding() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initialize() {
        //todo
    }
}
