package com.base.mvvm.core.custom

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.base.mvvm.R
import com.base.mvvm.core.utilities.DeviceUtilities

class ToolBarCommon : Toolbar {
    lateinit var btnLeft: ImageView
    lateinit var btnRight: TextView
    lateinit var tvTitle: TextView
    lateinit var viewStatusBar: View
    private var srcLeft = -1
    private var srcRight: String? = ""
    private var stringTitle: String? = ""
    private var isTransStatusBar = false
    private var onToolBarClickListener: OnToolBarClickListener? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        val a =
            context.theme.obtainStyledAttributes(attrs, R.styleable.ToolBarCommon, 0, 0)
        srcLeft = a.getResourceId(R.styleable.ToolBarCommon_src_left, -1)
        srcRight = a.getString(R.styleable.ToolBarCommon_src_right)
        stringTitle = a.getString(R.styleable.ToolBarCommon_string_title)
        isTransStatusBar = a.getBoolean(R.styleable.ToolBarCommon_trans_status_bar, false)
        if (TextUtils.isEmpty(stringTitle)) {
            stringTitle = resources.getString(
                a.getResourceId(
                    R.styleable.ToolBarCommon_string_title,
                    R.string.text_empty
                )
            )
        }
        init()
    }

    private fun init() {
        setContentInsetsAbsolute(0, 0)
        View.inflate(context, R.layout.tool_bar_common, this)
        btnLeft = findViewById(R.id.btn_left)
        btnRight = findViewById(R.id.tvRight)
        tvTitle = findViewById(R.id.tv_title)
        viewStatusBar = findViewById(R.id.view_status_bar)
        if (isTransStatusBar) {
            viewStatusBar.visibility = View.VISIBLE
            val layoutParams =
                viewStatusBar.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.height = DeviceUtilities.getStatusBarHeight(context)
        } else {
            viewStatusBar.visibility = View.GONE
        }
        btnLeft.setOnClickListener(OnClickListener {
            if (onToolBarClickListener != null) {
                onToolBarClickListener!!.onClickLeft()
            }
        })
        btnRight.setOnClickListener(OnClickListener {
            if (onToolBarClickListener != null) {
                onToolBarClickListener!!.onClickRight()
            }
        })
        setSrcLeft(srcLeft)
        setSrcRight(srcRight)
        setTvTitle(stringTitle)
    }

    fun setSrcLeft(@DrawableRes src: Int) {
        if (src != -1) {
            btnLeft.visibility = View.VISIBLE
            btnLeft.setImageResource(src)
        } else {
            btnLeft.visibility = View.INVISIBLE
        }
    }

    fun setSrcRight(src: String?) {
        if (src != null) {
            btnRight.visibility = View.VISIBLE
            btnRight.text = src
        } else {
            btnRight.visibility = View.INVISIBLE
        }
    }

    fun setTvTitle(title: String?) {
        if (!TextUtils.isEmpty(title)) {
            tvTitle.text = title
        } else {
            tvTitle.text = ""
        }
    }

    fun setLeftEnable(enable: Boolean) {
        btnLeft.isEnabled = enable
    }

    fun setRightEnable(enable: Boolean) {
        btnRight.isEnabled = enable
    }

    fun setOnToolBarClickListener(onToolBarClickListener: OnToolBarClickListener?) {
        this.onToolBarClickListener = onToolBarClickListener
    }

    abstract class OnToolBarClickListener {
        open fun onClickLeft() {

        }

        open fun onClickRight() {

        }
    }
}