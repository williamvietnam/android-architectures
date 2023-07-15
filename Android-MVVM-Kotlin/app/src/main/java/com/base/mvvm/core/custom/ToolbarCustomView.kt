package com.base.mvvm.core.custom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.base.mvvm.R
import com.base.mvvm.databinding.ToolBarCustomViewBinding

class ToolbarCustomView : FrameLayout {
    private lateinit var binding: ToolBarCustomViewBinding
    private lateinit var callbackStart: ToolbarCallbackStart
    private lateinit var callBackEnd: ToolbarCallBackEnd

    constructor(context: Context) : super(context) {
        initialize(context = context, attributeSet = null)
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        initialize(context = context, attributeSet = attributeSet)
    }

    constructor(
        context: Context,
        attributeSet: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attributeSet, defStyleAttr) {
        initialize(context = context, attributeSet = attributeSet)
    }

    private fun initialize(context: Context, attributeSet: AttributeSet?) {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        this.binding = ToolBarCustomViewBinding.inflate(inflater, this, true)

        this.binding.buttonStart.setOnClickListener {
            callbackStart.onToolbarClickStart()
        }

        this.binding.buttonEnd.setOnClickListener {
            callBackEnd.onToolbarClickEnd()
        }

        if (attributeSet != null) {
            val typedArray: TypedArray = context.theme.obtainStyledAttributes(
                attributeSet,
                R.styleable.ToolbarCustomView,
                0,
                0
            )

            val background: Drawable? =
                typedArray.getDrawable(R.styleable.ToolbarCustomView_toolbarBackground)
            this.binding.rootView.background = background

            val drawableStart: Drawable? =
                typedArray.getDrawable(R.styleable.ToolbarCustomView_drawableStart)
            if (drawableStart != null) {
                this.binding.drawableStart.setImageDrawable(drawableStart)
                this.binding.drawableStart.visibility = VISIBLE
            } else {
                this.binding.drawableStart.visibility = GONE
            }

            val toolbarTitle: String? =
                typedArray.getString(R.styleable.ToolbarCustomView_toolbarText)
            val toolbarTitleRes: Int =
                typedArray.getInt(R.styleable.ToolbarCustomView_toolbarText, 0)
            if (toolbarTitle != null) {
                this.binding.toolbarText.text = toolbarTitle
                this.binding.toolbarText.visibility = VISIBLE
            } else if (toolbarTitleRes != 0) {
                this.binding.toolbarText.setText(toolbarTitleRes)
                this.binding.toolbarText.visibility = VISIBLE
            } else {
                this.binding.toolbarText.visibility = INVISIBLE
            }

            val drawableEnd: Drawable? =
                typedArray.getDrawable(R.styleable.ToolbarCustomView_drawableEnd)
            if (drawableEnd != null) {
                this.binding.drawableEnd.setImageDrawable(drawableEnd)
                this.binding.drawableEnd.visibility = VISIBLE
            } else {
                this.binding.drawableEnd.visibility = GONE
            }
        }
    }

    interface ToolbarCallbackStart {
        fun onToolbarClickStart()
    }

    interface ToolbarCallBackEnd {
        fun onToolbarClickEnd()
    }
}