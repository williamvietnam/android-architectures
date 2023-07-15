package com.base.mvp.core.base.mvp

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.base.mvp.core.base.BaseContractPresenter
import com.base.mvp.core.base.BaseContractView
import com.base.mvp.core.base.BaseMvpFragment
import javax.inject.Inject

abstract class MvpFragment<
        VB: ViewBinding,
        V: BaseContractView,
        P: BaseContractPresenter<V>>
    : BaseMvpFragment<VB>(), BaseContractView {

    @Inject
    lateinit var presenter: P

    private lateinit var activity: MvpActivity<VB, V, P>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MvpActivity<*, *, *>) {
            val activity: MvpActivity<VB, V, P> = context as MvpActivity<VB, V, P>
            this.activity = activity
        }
    }
}