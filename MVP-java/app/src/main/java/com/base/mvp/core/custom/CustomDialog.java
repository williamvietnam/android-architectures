package com.base.mvp.core.custom;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.base.mvp.R;

/**
 * Author: William Giang Nguyen | 25/06/2022
 */
public class CustomDialog {

    /**
     * custom progress dialog | 25/06/2022
     * */
    @NonNull
    public static Dialog showLoadingDialog(@NonNull Context context) {
        Dialog dialog = new Dialog(context, R.style.FullScreen_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.color_white_90);
        // setup full height status bar
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_progress_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return dialog;
    }
}
