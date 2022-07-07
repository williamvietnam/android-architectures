package com.base.mvvm.core.utilities.dialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.TextView
import androidx.annotation.StringRes
import com.base.mvvm.R

class BaseDialog {
    private lateinit var dialog: AlertDialog
    private var builder: AlertDialog.Builder
    private lateinit var context: Context

    constructor(context: Context?) {
        builder = AlertDialog.Builder(context)
            .setOnDismissListener { initialize() }

    }

    constructor(
        context: Context?, title: String?, message: String?,
        positive: String?, onPositiveClick: OnDialogListener?,
        negative: String?, onNegativeClick: OnDialogListener?,
        isCancelable: Boolean
    ) {
        builder = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                positive
            ) { dialog1: DialogInterface, _: Int ->
                dialog1.cancel()
                onPositiveClick?.onClick()
            }
            .setNegativeButton(
                negative
            ) { dialog1: DialogInterface, _: Int ->
                dialog1.cancel()
                onNegativeClick?.onClick()
            }
            .setOnDismissListener { initialize() }
            .setCancelable(isCancelable)
        dialog = builder.create()
        dialog.show()
    }

    fun setTitle(title: String?): BaseDialog {
        builder.setTitle(title)
        return this
    }

    fun setTitle(@StringRes title: Int): BaseDialog {
        builder.setTitle(title)
        return this
    }

    fun setMessage(message: String?): BaseDialog {
        builder.setMessage(message)
        return this
    }

    fun setMessage(@StringRes message: Int): BaseDialog {
        builder.setMessage(message)
        return this
    }

    fun setPositiveButton(label: String? = "Ok", onDialogListener: OnDialogListener?): BaseDialog {
        builder.setPositiveButton(
            label
        ) { dialog: DialogInterface, _: Int ->
            dialog.cancel()
            initialize()
            onDialogListener?.onClick()
        }
        return this
    }

    fun setPositiveButton(@StringRes label: Int, onDialogListener: OnDialogListener?): BaseDialog {
        builder.setPositiveButton(
            label
        ) { dialog: DialogInterface, _: Int ->
            dialog.cancel()
            initialize()
            onDialogListener?.onClick()
        }
        return this
    }

    fun setNegativeButton(label: String?, onDialogListener: OnDialogListener?): BaseDialog {
        builder.setNegativeButton(
            label
        ) { dialog: DialogInterface, _: Int ->
            dialog.cancel()
            initialize()
            onDialogListener?.onClick()
        }
        return this
    }

    fun setNegativeButton(@StringRes label: Int, onDialogListener: OnDialogListener?): BaseDialog {
        builder.setNegativeButton(
            label
        ) { dialog: DialogInterface, _: Int ->
            dialog.cancel()
            initialize()
            onDialogListener?.onClick()
        }
        return this
    }

    fun setCancelable(isCancelable: Boolean): BaseDialog {
        builder.setCancelable(isCancelable)
        builder.setOnCancelListener { initialize() }
        return this
    }

    fun setCancelable(
        isCancelable: Boolean,
        onDialogListener: OnDialogListener?
    ): BaseDialog {
        builder.setCancelable(isCancelable)
        builder.setOnCancelListener { dialog: DialogInterface ->
            dialog.cancel()
            initialize()
            onDialogListener?.onClick()
        }
        return this
    }

//    fun setOnDissmiss(
//        onDialogListener: OnDialogListener?
//    ): BaseDialog {
//        builder.setOnDismissListener {
//            onDialogListener?.onDissmiss()
//        }
//        return this
//    }

    fun show() {
        if (!isShown) {
            dialog = builder.create()
            dialog.setCanceledOnTouchOutside(false)
            dialog.window?.setBackgroundDrawableResource(R.drawable.bg_alert_dialog_custom)
            dialog.show()
            forceShown()
            val textSize = dialog.context.resources.getDimension(R.dimen.text_size_18)
            dialog.findViewById<TextView>(android.R.id.message).textSize = textSize
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).textSize = textSize
            dialog.getButton(DialogInterface.BUTTON_NEGATIVE).textSize = textSize
        }
    }

    fun isShow() = isShown

    interface OnDialogListener {
        fun onClick()
    }

    companion object {
        private var isShown = false

        private fun forceShown() {
            isShown = true
        }

        private fun initialize() {
            isShown = false
        }
    }
}