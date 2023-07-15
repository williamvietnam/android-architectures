package com.mvvm.java.core.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.mvvm.java.R;
import com.mvvm.java.databinding.CustomToolbarBinding;

public class ToolbarCustomView extends FrameLayout {
    private static final String TAG = "ToolbarCustomView";
    private CustomToolbarBinding binding;
    private ToolbarCallBackStart callBackStart;
    private ToolbarCallBackEnd callBackEnd;

    public ToolbarCustomView(@NonNull Context context) {
        super(context);
        initialize(context, null);
    }

    public ToolbarCustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public ToolbarCustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }

    public void setCallBackStart(ToolbarCallBackStart callBackStart) {
        this.callBackStart = callBackStart;
    }

    public void setCallBackEnd(ToolbarCallBackEnd callBackEnd) {
        this.callBackEnd = callBackEnd;
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        LayoutInflater inflater = LayoutInflater.from(context);
        this.binding = CustomToolbarBinding.inflate(inflater, ToolbarCustomView.this, true);

        this.binding.buttonStart.setOnClickListener(view -> {
            callBackStart.onToolbarClickStart();
            Log.d(TAG, "onClickStart");
        });

        this.binding.buttonEnd.setOnClickListener(view -> {
            callBackEnd.onToolbarClickEnd();
            Log.d(TAG, "onClickEnd");
        });

        if (attributeSet != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ToolbarCustomView, 0, 0);

            Drawable drawableStart = typedArray.getDrawable(R.styleable.ToolbarCustomView_drawableStart);
            if (drawableStart != null) {
                this.binding.drawableStart.setImageDrawable(drawableStart);
                this.binding.buttonStart.setVisibility(VISIBLE);
                this.binding.drawableStart.setVisibility(VISIBLE);
            } else {
                this.binding.buttonStart.setVisibility(GONE);
                this.binding.drawableStart.setVisibility(GONE);
            }

            String toolbarText = typedArray.getString(R.styleable.ToolbarCustomView_toolbarText);
            int toolbarTextRes = typedArray.getInt(R.styleable.ToolbarCustomView_toolbarText, 0);
            if (toolbarText != null) {
                this.binding.toolbarText.setText(toolbarText);
                this.binding.toolbarText.setVisibility(VISIBLE);
            } else if (toolbarTextRes != 0) {
                this.binding.toolbarText.setText(toolbarTextRes);
                this.binding.toolbarText.setVisibility(VISIBLE);
            } else {
                this.binding.toolbarText.setVisibility(GONE);
            }

            Drawable drawableEnd = typedArray.getDrawable(R.styleable.ToolbarCustomView_drawableEnd);
            if (drawableEnd != null) {
                this.binding.drawableEnd.setImageDrawable(drawableEnd);
                this.binding.buttonEnd.setVisibility(VISIBLE);
                this.binding.drawableEnd.setVisibility(VISIBLE);
            } else {
                this.binding.buttonEnd.setVisibility(GONE);
                this.binding.drawableEnd.setVisibility(GONE);
            }
        }
    }

    public void setDrawableStart(@DrawableRes int res) {
        this.binding.drawableStart.setImageResource(res);
    }

    public void setToolbarName(String name) {
        this.binding.toolbarText.setText(name);
    }

    public void setToolbarName(@StringRes int name) {
        this.binding.toolbarText.setText(name);
    }

    public void setDrawableEnd(@DrawableRes int res) {
        this.binding.drawableEnd.setImageResource(res);
    }

    public interface ToolbarCallBackStart {
        void onToolbarClickStart();
    }

    public interface ToolbarCallBackEnd {
        void onToolbarClickEnd();
    }
}