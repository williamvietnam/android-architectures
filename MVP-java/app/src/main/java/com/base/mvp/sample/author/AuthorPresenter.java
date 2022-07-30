package com.base.mvp.sample.author;

import com.base.mvp.core.base.BaseMvpPresenter;

public class AuthorPresenter<V extends AuthorContract.View>
        extends BaseMvpPresenter<V> implements AuthorContract.Presenter<V> {
}
