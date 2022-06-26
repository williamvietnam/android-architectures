package com.base.mvvm.core.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.base.mvvm.R

class WidgetDialog(context: Context) : Dialog(context, R.style.WidgetDialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widget_dialog_progress)
        setCancelable(false)
    }
}