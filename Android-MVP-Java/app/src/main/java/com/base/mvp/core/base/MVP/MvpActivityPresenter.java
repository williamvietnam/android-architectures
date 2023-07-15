package com.base.mvp.core.base.MVP;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.base.mvp.core.base.BaseContractPresenter;
import com.base.mvp.core.base.BaseContractView;
import com.base.mvp.core.base.BaseMvpActivity;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public abstract class MvpActivityPresenter<
        VB extends ViewBinding,
        V extends BaseContractView,
        P extends BaseContractPresenter<V>>
        extends BaseMvpActivity<VB> implements BaseContractView {

    public P presenter;

    public abstract P getPresenter();

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (presenter == null) {
            presenter = getPresenter();
        }
        getLifecycle().addObserver(presenter);
        presenter.onAttachView((V) this);
        super.onCreate(savedInstanceState);
    }
}
