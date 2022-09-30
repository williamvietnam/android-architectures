package com.mvvm.java.sample.welcome;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.mvvm.java.core.base.mvvm.MVVMActivity;
import com.mvvm.java.core.di.component.ActivityComponent;
import com.mvvm.java.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends MVVMActivity<ActivityWelcomeBinding, WelcomeViewModel> {

    @Override
    public ActivityWelcomeBinding createViewBinding() {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
        }
        return ActivityWelcomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setup() {
        WelcomeAdapter adapter = new WelcomeAdapter(viewModel.getWelcomes());
        this.viewBinding.viewPager.setAdapter(adapter);
        this.viewBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        viewBinding.indicatorStart.active.setVisibility(View.VISIBLE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.GONE);
                        viewBinding.indicatorStart.active.setVisibility(View.GONE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.VISIBLE);
                        viewBinding.indicatorStart.active.setVisibility(View.GONE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        viewBinding.indicatorStart.active.setVisibility(View.GONE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.VISIBLE);
                        viewBinding.indicatorStart.active.setVisibility(View.VISIBLE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.GONE);
                        viewBinding.indicatorStart.active.setVisibility(View.GONE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        viewBinding.indicatorStart.active.setVisibility(View.GONE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.VISIBLE);
                        viewBinding.indicatorStart.active.setVisibility(View.GONE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.VISIBLE);
                        viewBinding.indicatorStart.active.setVisibility(View.VISIBLE);
                        viewBinding.indicatorStart.inactive.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }
}