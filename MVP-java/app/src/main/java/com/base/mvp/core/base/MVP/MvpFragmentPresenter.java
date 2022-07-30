package com.base.mvp.core.base.MVP;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.base.mvp.core.base.BaseContractPresenter;
import com.base.mvp.core.base.BaseContractView;
import com.base.mvp.core.base.BaseMvpFragment;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public abstract class MvpFragmentPresenter<
        VB extends ViewBinding,
        V extends BaseContractView,
        P extends BaseContractPresenter<V>>
        extends BaseMvpFragment<VB> implements BaseContractView {

    public P presenter;

    public abstract P getPresenter();

    @SuppressWarnings("unchecked")
    @CallSuper
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = getPresenter();
        }
        getLifecycle().addObserver(presenter);
        presenter.attachView((V) this);
    }
}
