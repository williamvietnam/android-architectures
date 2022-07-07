package com.base.mvvm.core.utilities

import android.content.Context
import android.util.TypedValue
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.text.PrecomputedTextCompat

@ColorInt
fun Context.getColorCompat(@ColorRes resourceId: Int) = ContextCompat.getColor(this, resourceId)

fun Context.getDrawableCompat(@DrawableRes resId: Int) = ContextCompat.getDrawable(this, resId)

fun ImageView.setDrawableCompat(context: Context, @DrawableRes resId: Int) =
    setImageDrawable(context.getDrawableCompat(resId))

fun Context.getDimension(@DimenRes resourceId: Int) = resources.getDimension(resourceId)

val Context.screenWidth: Int
    get() = resources.displayMetrics.widthPixels

val Context.screenHeight: Int
    get() = resources.displayMetrics.heightPixels

fun Context.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun Context.getPxFromDp(dp: Float) = TypedValue
    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

fun AppCompatTextView.setTextCompute(text: CharSequence) {
    setTextFuture(PrecomputedTextCompat.getTextFuture(text, textMetricsParamsCompat, null))
}
