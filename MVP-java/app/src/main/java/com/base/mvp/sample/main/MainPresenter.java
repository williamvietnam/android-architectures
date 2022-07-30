package com.base.mvp.sample.main;

import com.base.mvp.core.base.BaseMvpPresenter;

/**
 * Author: William Giang Nguyen | 25/06/2022
 * */
public class MainPresenter<V extends MainContract.View>
        extends BaseMvpPresenter<V> implements MainContract.Presenter<V> {

}
