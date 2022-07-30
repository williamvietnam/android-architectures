package com.base.mvp.sample.login;

import com.base.mvp.core.base.BaseMvpPresenter;

public class LoginPresenter<V extends LoginContract.View>
        extends BaseMvpPresenter<V> implements LoginContract.Presenter<V> {

}
