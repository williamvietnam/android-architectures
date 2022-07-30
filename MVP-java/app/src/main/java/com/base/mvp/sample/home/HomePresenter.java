package com.base.mvp.sample.home;

import com.base.mvp.core.base.BaseMvpPresenter;

public class HomePresenter<V extends HomeContract.View>
        extends BaseMvpPresenter<V> implements HomeContract.Presenter<V> {
}
