package com.base.mvvm.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.IntDef
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.base.mvvm.databinding.ItemListHeaderBinding
import com.base.mvvm.databinding.ItemLoadMoreBinding

abstract class BaseAdapter<T>(activityContext: AppCompatActivity) :
    RecyclerView.Adapter<BaseViewHolder>() {
    @IntDef(LOAD_MORE, HEADER, DATA)
    annotation class ITEM_TYPE

    protected var context: Context
    protected var itemList: MutableList<BaseAdapterModel<T>>
    protected var itemClickListener: ItemClickListener<T>? = null

    @JvmName("setItemClickListener1")
    fun setItemClickListener(itemClickListener: ItemClickListener<T>?) {
        this.itemClickListener = itemClickListener
    }

    fun reset() {
        itemList.clear()
        notifyDataSetChanged()
    }

    val data: List<T>
        get() {
            val data: MutableList<T> = ArrayList()
            for (i in itemList.indices) {
                if (itemList[i].type == DATA) {
                    itemList[i].data?.let {
                        data.add(it)
                    }
                }
            }
            return data
        }

    fun addHeader(header: Header) {
        itemList.add(BaseAdapterModel(header))
        notifyItemInserted(itemList.size - 1)
    }

    fun addLoadMore() {
        itemList.add(BaseAdapterModel())
        notifyItemInserted(itemList.size - 1)
    }

    fun removeLoadMore() {
        if (itemList.isNotEmpty() && itemList[itemList.size - 1].type == LOAD_MORE) {
            itemList.removeAt(itemList.size - 1)
            notifyItemRemoved(itemList.size)
        }
    }

    fun addData(dataList: List<T>) {
        for (data in dataList) {
            itemList.add(BaseAdapterModel(data))
        }
        notifyItemRangeInserted(itemList.size - dataList.size, dataList.size)
    }

    fun add(data: T) {
        itemList.add(BaseAdapterModel(data))
        notifyItemInserted(itemList.size - 1)
    }

    fun remove(position: Int) {
        if (itemList.isNotEmpty()) {
            itemList.removeAt(position)
        }
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            HEADER -> {
                val binding: ItemListHeaderBinding =
                    ItemListHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                HeaderViewHolder(binding)
            }
            LOAD_MORE -> {
                val binding: ItemLoadMoreBinding =
                    ItemLoadMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                LoadMoreViewHolder(binding)
            }
            else -> {    // DATA
                createDataView(parent)
            }
        }
    }

    protected abstract fun createDataView(@NonNull parent: ViewGroup?): BaseViewHolder

    override fun onBindViewHolder(@NonNull holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    interface ItemClickListener<T> {
        fun onItemClick(item: T)
        fun onAction1Click(item: Header?)
        fun onAction2Click(item: Header?)
    }

    class Header(
        val header: String,
        val subHeader: String,
        @field:DrawableRes @param:DrawableRes val action1Res: Int,
        @field:DrawableRes @param:DrawableRes val action2Res: Int
    )

    private class LoadMoreViewHolder(binding: ItemLoadMoreBinding) :
        BaseViewHolder(binding.root) {
        var binding: ItemLoadMoreBinding

        override fun onBind(position: Int) {
            super.onBind(position)
        }

        override fun clear() {}

        init {
            this.binding = binding
        }
    }

    inner class HeaderViewHolder(viewBinding: ItemListHeaderBinding) :
        BaseViewHolder(viewBinding.root) {
        var viewBinding: ItemListHeaderBinding
        override fun onBind(position: Int) {
            super.onBind(position)
            val header = itemList[position].header
            if (header != null) {
                if (isNullOrEmpty(header.header)) {
                    viewBinding.tvHeader.visibility = View.GONE
                } else {
                    viewBinding.tvHeader.text = header.header
                    viewBinding.tvHeader.visibility = View.VISIBLE
                }
                if (isNullOrEmpty(header.subHeader)) {
                    viewBinding.tvSubHeader.visibility = View.GONE
                } else {
                    viewBinding.tvSubHeader.text = header.subHeader
                    viewBinding.tvSubHeader.visibility = View.VISIBLE
                }
                if (header.action1Res > 0) {
                    viewBinding.ivAction1.setImageResource(header.action1Res)
                    viewBinding.ivAction1.setOnClickListener {
                        itemClickListener?.onAction1Click(
                            header
                        )
                    }
                    viewBinding.ivAction1.visibility = View.VISIBLE
                } else {
                    viewBinding.ivAction1.visibility = View.GONE
                }
                if (header.action2Res > 0) {
                    viewBinding.ivAction2.setImageResource(header.action2Res)
                    viewBinding.ivAction2.setOnClickListener {
                        itemClickListener?.onAction2Click(
                            header
                        )
                    }
                    viewBinding.ivAction2.visibility = View.VISIBLE
                } else {
                    viewBinding.ivAction2.visibility = View.GONE
                }
            } else {
//                AppLogger.e("Item at position $position is not a header")
            }
        }

        override fun clear() {
            viewBinding.tvHeader.visibility = View.GONE
            viewBinding.tvSubHeader.visibility = View.GONE
            viewBinding.ivAction1.visibility = View.GONE
            viewBinding.ivAction2.visibility = View.GONE
        }

        init {
            this.viewBinding = viewBinding
        }

        private fun isNullOrEmpty(str: String?): Boolean {
            return str == null || str.isEmpty()
        }
    }

    class BaseAdapterModel<T> {
        @ITEM_TYPE
        var type: Int
        var header: Header?
        var data: T?
            private set

        // Constructor for LOAD_MORE
        constructor() {
            this.type = LOAD_MORE
            this.header = null
            this.data = null
        }

        // Constructor for HEADER
        constructor(@Nullable header: Header) {
            this.type = HEADER
            this.header = header
            this.data = null
        }

        // Constructor for DATA
        constructor(data: T) {
            this.type = DATA
            this.header = null
            this.data = data
        }
    }

    companion object {
        const val LOAD_MORE = 0
        const val HEADER = 1
        const val DATA = 2
    }

    init {
        context = activityContext
        itemList = ArrayList()
    }
}
