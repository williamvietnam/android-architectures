package com.base.mvvm.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewAdapter<T>(context: Context, private val mCollection: List<T>?) :
    RecyclerView.Adapter<BaseViewAdapter.BindingViewHolder<T>>() {

    private var onItemClickListener: OnItemClickListener? = null

    private val mLayoutInflater by lazy {
        LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<T>, position: Int) {
        val item: T = mCollection?.get(position)!!
        holder.bindData(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<T> {
        return BindingViewHolder(
            DataBindingUtil.inflate(mLayoutInflater, layoutId(), parent, false),
            onItemClickListener
        )
    }

    override fun getItemCount(): Int {
        if (mCollection == null) {
            return 0
        }
        return mCollection.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    @LayoutRes
    protected abstract fun layoutId(): Int

    class BindingViewHolder<T>(
        val binding: ViewDataBinding,
        onItemClickListener: OnItemClickListener? = null
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }

        fun bindData(item: T) {
//            binding.setVariable(BR.viewModel, item)
            binding.executePendingBindings()
        }
    }
}
