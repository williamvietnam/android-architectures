package com.base.mvp.core.base.MVP_v2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.base.mvp.core.base.BaseContractPresenter;
import com.base.mvp.core.base.BaseContractView;
import com.base.mvp.core.base.BaseMvpFragment;
import com.base.mvp.core.di.component.ActivityComponent;

import javax.inject.Inject;

public abstract class MvpFragmentDI<
        VB extends ViewBinding, V extends BaseContractView, P extends BaseContractPresenter<V>>
        extends BaseMvpFragment<VB> implements BaseContractView {

    @Inject
    public P presenter;

    private MvpActivityDI<VB, V, P> activityDI;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MvpActivityDI) {
            MvpActivityDI<VB, V, P> activity = (MvpActivityDI<VB, V, P>) context;
            this.activityDI = activity;
        }
    }

    public ActivityComponent getActivityComponent() {
        if (activityDI != null) {
            return activityDI.getActivityComponent();
        }
        return null;
    }
}
