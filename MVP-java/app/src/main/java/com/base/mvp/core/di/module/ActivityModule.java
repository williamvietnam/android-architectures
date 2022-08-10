package com.base.mvp.core.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.base.mvp.core.di.ActivityContext;
import com.base.mvp.core.di.PerActivity;
import com.base.mvp.core.utilities.rx.SchedulerProvider;
import com.base.mvp.core.utilities.rx.SchedulerProviderImpl;
import com.base.mvp.sample.author.AuthorContract;
import com.base.mvp.sample.author.AuthorPresenter;
import com.base.mvp.sample.home.HomeContract;
import com.base.mvp.sample.home.HomePresenter;
import com.base.mvp.sample.login.LoginContract;
import com.base.mvp.sample.login.LoginPresenter;
import com.base.mvp.sample.main.MainContract;
import com.base.mvp.sample.main.MainPresenter;
import com.base.mvp.sample.splash.SplashContract;
import com.base.mvp.sample.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new SchedulerProviderImpl();
    }

    @Provides
    @PerActivity
    SplashContract.Presenter<SplashContract.View> provideSplashPresenter(SplashPresenter<SplashContract.View> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginContract.Presenter<LoginContract.View> provideLoginPresenter(LoginPresenter<LoginContract.View> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainContract.Presenter<MainContract.View> provideMainPresenter(MainPresenter<MainContract.View> presenter) {
        return presenter;
    }

    @Provides
    HomeContract.Presenter<HomeContract.View> provideHomePresenter(HomePresenter<HomeContract.View> presenter) {
        return presenter;
    }

    @Provides
    AuthorContract.Presenter<AuthorContract.View> provideAuthorPresenter(AuthorPresenter<AuthorContract.View> presenter) {
        return presenter;
    }
}
