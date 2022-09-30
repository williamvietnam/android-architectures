package com.mvvm.java.core.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.mvvm.java.R;
import com.mvvm.java.databinding.TextFieldBinding;

public class TextField extends LinearLayout {

    private TextFieldBinding binding;

    public TextField(Context context) {
        super(context);
        initialize(context, null);
    }

    public TextField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public TextField(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }

    private void initialize(Context context, @Nullable AttributeSet attrs) {
        LayoutInflater inflater = LayoutInflater.from(context);
        this.binding = TextFieldBinding.inflate(inflater, TextField.this, true);

        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TextField, 0, 0);
        }
    }
}