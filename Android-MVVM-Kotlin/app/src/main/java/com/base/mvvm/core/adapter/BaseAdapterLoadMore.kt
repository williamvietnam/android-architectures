package com.base.mvvm.core.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

abstract class BaseAdapterLoadMore<D>(diff: DiffUtil.ItemCallback<D>) :
    ListAdapter<D, RecyclerView.ViewHolder>(diff) {
    var disableLoadMore = true
    var isLoading = false
    private val visibleThreshold = 1
    private var loadMoreListener: LoadMoreListener? = null
    private var dataList: MutableList<D?> = mutableListOf()
    private var recyclerView: RecyclerView? = null
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBinViewHolderNomal(holder, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateViewHolderNormal(parent, viewType)
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading = isLoading
    }

    fun setDisableLoadmore(disableLoadMore: Boolean) {
        this.disableLoadMore = disableLoadMore
    }

    fun setLoadMoreListener(loadMoreListener: LoadMoreListener) {
        disableLoadMore = false
        this.loadMoreListener = loadMoreListener
    }

    fun getLoadMoreListener() = this.loadMoreListener

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
        recyclerView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    when (newState) {
                        RecyclerView.SCROLL_STATE_IDLE -> {
                            if (disableLoadMore || isLoading) {
                                return
                            }
                            var lastVisibleItemPosition = 0
                            val layoutManager =
                                recyclerView.layoutManager
                            val totalItemCount = this@BaseAdapterLoadMore.itemCount
                            if (layoutManager is LinearLayoutManager) {
                                lastVisibleItemPosition =
                                    layoutManager.findLastVisibleItemPosition()
                            }
                            if (lastVisibleItemPosition + visibleThreshold >= totalItemCount) {
                                if (loadMoreListener != null) {
                                    Timber.tag("BaseAdapterLoadMore")
                                        .d("onScrollStateChanged() called with: recyclerView = " + recyclerView + ", newState = " + newState)
                                    loadMoreListener?.onLoadMore()
                                }
                            }
                        }
                        else -> {
                        }
                    }
                }
            }
        )
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
    }

    interface LoadMoreListener {
        fun onLoadMore()
    }

    abstract fun onBinViewHolderNomal(holder: RecyclerView.ViewHolder, position: Int)
    abstract fun onCreateViewHolderNormal(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
}