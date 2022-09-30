package com.mvvm.java.sample.container;

import com.mvvm.java.core.base.mvvm.MVVMActivity;
import com.mvvm.java.core.di.component.ActivityComponent;
import com.mvvm.java.databinding.ActivityMainBinding;

public class MainActivity extends MVVMActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public ActivityMainBinding createViewBinding() {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
        }
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setup() {

    }
}