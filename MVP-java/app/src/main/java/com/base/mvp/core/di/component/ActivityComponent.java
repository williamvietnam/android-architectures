package com.base.mvp.core.di.component;

import com.base.mvp.core.di.PerActivity;
import com.base.mvp.core.di.module.ActivityModule;
import com.base.mvp.sample.author.AuthorFragment;
import com.base.mvp.sample.home.HomeFragment;
import com.base.mvp.sample.home.banner.BannerDetailFragment;
import com.base.mvp.sample.login.LoginActivity;
import com.base.mvp.sample.main.MainActivity;
import com.base.mvp.sample.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(HomeFragment fragment);

    void inject(BannerDetailFragment fragment);

    void inject(AuthorFragment fragment);
}
