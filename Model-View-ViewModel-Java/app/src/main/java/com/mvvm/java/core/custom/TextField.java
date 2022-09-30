package com.mvvm.java.core.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

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

            String hintTextField = typedArray.getString(R.styleable.TextField_hintTextField);
            int hintTextFieldRes = typedArray.getInt(R.styleable.TextField_hintTextField, 0);
            if (hintTextField != null) {
                this.binding.textInputLayout.setHint(hintTextField);
            } else if (hintTextFieldRes != 0) {
                this.binding.textInputLayout.setHint(hintTextFieldRes);
            }

            String inputTextField = typedArray.getString(R.styleable.TextField_inputTextField);
            int inputTextFieldRes = typedArray.getInt(R.styleable.TextField_inputTextField, 0);
            if (inputTextField != null) {
                this.binding.textInputEditText.setText(inputTextField);
            } else if (inputTextFieldRes != 0) {
                this.binding.textInputEditText.setText(inputTextFieldRes);
            }
        }
    }

    public void setHintText(String hintText) {
        this.binding.textInputLayout.setHint(hintText);
    }

    public void setHintText(@StringRes int hintRes) {
        this.binding.textInputLayout.setHint(hintRes);
    }
}