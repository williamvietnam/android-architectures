package com.base.mvp.sample.author;

import com.base.mvp.core.base.BaseContractPresenter;
import com.base.mvp.core.base.BaseContractView;

public interface AuthorContract {
    interface View extends BaseContractView {

    }

    interface Presenter<V extends View> extends BaseContractPresenter<V> {

    }
}
