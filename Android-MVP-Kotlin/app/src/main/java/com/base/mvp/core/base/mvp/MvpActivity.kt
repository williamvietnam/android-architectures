package com.base.mvp.core.base.mvp

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.base.mvp.MVPApplication
import com.base.mvp.core.base.BaseContractPresenter
import com.base.mvp.core.base.BaseContractView
import com.base.mvp.core.base.BaseMvpActivity
import com.base.mvp.core.di.components.ActivityComponent
import com.base.mvp.core.di.modules.ActivityModule
import javax.inject.Inject

abstract class MvpActivity<
        VB : ViewBinding,
        V : BaseContractView,
        P : BaseContractPresenter<V>>
    : BaseMvpActivity<VB>(), BaseContractView {

    private lateinit var activityComponent: ActivityComponent

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as MVPApplication).getComponent())
            .build()
    }

    open fun getActivityComponent(): ActivityComponent? {
        return activityComponent
    }

}