package com.base.mvvm.core.baseMVVM

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.base.mvvm.R
import com.base.mvvm.core.utils.ContextUtils
import com.base.mvvm.core.utils.LocaleHelper
import com.base.mvvm.core.widget.WidgetProgressDialog
import java.util.*

abstract class MvvmActivity<VB : ViewBinding> : AppCompatActivity(), MvvmActivityView {

    lateinit var binding: VB
    lateinit var updatedContext: ContextWrapper
    private lateinit var progressDialog: WidgetProgressDialog

    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)

        this.progressDialog = WidgetProgressDialog(this)

        initialize()
    }

    override fun showProgressDialog(isShow: Boolean) {
        if (isShow) {
            showProgress()
        } else {
            dismissProgress()
        }
    }

    override fun showDialogInfo(
        titleId: Int,
        messageId: Int,
        cancel: (() -> Unit)?,
        close: (() -> Unit)?,
        dismissClickOutSide: Boolean
    ) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val customLayout: View = layoutInflater.inflate(R.layout.widget_dialog_info, null)
        builder.setView(customLayout)
        val dialog: AlertDialog = builder.create()
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        customLayout.findViewById<TextView>(R.id.title).setText(titleId)
        customLayout.findViewById<TextView>(R.id.msg_content).setText(messageId)
        customLayout.findViewById<Button>(R.id.btn_close).setOnClickListener {
            dialog.dismiss()
            close?.invoke()
        }
        customLayout.findViewById<ImageView>(R.id.btn_dismiss).setOnClickListener {
            dialog.dismiss()
            cancel?.invoke()
        }
        dialog.window?.setGravity(Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(dismissClickOutSide)

        dialog.show()
    }

    override fun showWarningDialog(msg: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val customLayout: View = layoutInflater.inflate(R.layout.widget_dialog_warning, null)
        val tvMessage = customLayout.findViewById<TextView>(R.id.msg_content)
        tvMessage?.let { content ->
            content.text = msg
        }
        builder.setView(customLayout)
        val dialog: AlertDialog = builder.create()
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        customLayout.findViewById<Button>(R.id.btn_no).setOnClickListener { dialog.dismiss() }
        customLayout.findViewById<ImageView>(R.id.btn_close).setOnClickListener { dialog.dismiss() }
        dialog.window?.setGravity(Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
    }

    override fun showWarningDialog(resId: Int) {
        showWarningDialog(getString(resId))
    }

    override fun attachBaseContext(base: Context?) {
        val language = base?.let { LocaleHelper.getLanguage(it) }
        super.attachBaseContext(language?.let {
            updatedContext = ContextUtils.updateLocale(base, Locale(language))
            updatedContext
        })
    }

    private fun showProgress() {
        if (!progressDialog.isShowing) progressDialog.show()
    }

    private fun dismissProgress() {
        if (progressDialog.isShowing) progressDialog.dismiss()
    }

}