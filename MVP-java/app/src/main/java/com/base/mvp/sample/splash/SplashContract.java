package com.base.mvp.sample.splash;

import com.base.mvp.core.base.BaseContractPresenter;
import com.base.mvp.core.base.BaseContractView;

public interface SplashContract {
    interface View extends BaseContractView {

    }

    interface Presenter<V extends View> extends BaseContractPresenter<V> {

    }
}
