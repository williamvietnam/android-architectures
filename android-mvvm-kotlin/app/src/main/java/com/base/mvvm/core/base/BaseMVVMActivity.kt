package com.base.mvvm.core.base

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.base.mvvm.R
import com.base.mvvm.core.utilities.dialog.BaseDialog
import com.base.mvvm.core.utilities.dialog.LoadingDialog
import timber.log.Timber
import java.lang.ref.WeakReference

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
abstract class BaseMVVMActivity<BD : ViewDataBinding> : AppCompatActivity() {

    private var _binding: BD? = null
    val binding: BD get() = _binding!!

    @get: LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(WeakReference(this).get()!!, layoutId)
        _binding?.lifecycleOwner = this

    }

    override fun onDestroy() {
        _binding?.unbind()
        _binding = null
        LoadingDialog.getInstance(this)?.destroyLoadingDialog()
        super.onDestroy()
    }

    fun showLoading() {
        LoadingDialog.getInstance(this)?.show()
    }

    fun hiddenLoading() {
        LoadingDialog.getInstance(this)?.hidden()
    }

    /**
     * Close SoftKeyboard when user click out of EditText
     */
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Timber.d("onBackPressed in activity")
    }

    private fun showAlertDialog(message: String) {
        BaseDialog(this)
            .setMessage(message)
            .setPositiveButton(R.string.ok, null)
            .show()
    }
}