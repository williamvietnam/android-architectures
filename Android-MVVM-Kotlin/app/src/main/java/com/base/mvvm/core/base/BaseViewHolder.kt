package com.base.mvvm.core.base

import android.view.View

import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var currentPosition = 0

    open fun onBind(position: Int) {
        this.currentPosition = position
        clear()
    }

    protected abstract fun clear()

    fun getCurrentPosition(): Int {
        return this.currentPosition
    }
}