package com.base.mvvm.core.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.base.mvvm.R

class WidgetProgressDialog(context: Context) : Dialog(context, R.style.WidgetProgressDialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widget_dialog_progress)
        setCancelable(false)
    }
}