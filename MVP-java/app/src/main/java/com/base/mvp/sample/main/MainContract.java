package com.base.mvp.sample.main;

import com.base.mvp.core.base.BaseContractPresenter;
import com.base.mvp.core.base.BaseContractView;

/**
 * Author: William Giang Nguyen | 25/06/2022
 * */
public interface MainContract {
    interface View extends BaseContractView {

    }

    interface Presenter<V extends View> extends BaseContractPresenter<V> {

    }
}
