package com.base.mvvm.samples.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.base.mvvm.R
import com.base.mvvm.core.adapter.BaseAdapter
import com.base.mvvm.core.adapter.BaseViewHolder
import com.base.mvvm.databinding.ItemStoryBinding
import com.base.mvvm.samples.models.Story
import com.squareup.picasso.Picasso

class StoriesAdapter(
    private val stories: List<Story>,
    private val callback: CallBack,
    activity: AppCompatActivity
) : BaseAdapter<BaseViewHolder>(activity) {

    override fun createDataView(parent: ViewGroup?): BaseViewHolder {
        return StoriesViewHolder(
            ItemStoryBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
        )
    }

    inner class StoriesViewHolder(private val binding: ItemStoryBinding) :
        BaseViewHolder(binding.root) {

        override fun onBind(position: Int) {
            super.onBind(position)
            val item = stories[position]

            Picasso.get()
                .load(item.image)
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_image)
                .centerCrop()
                .into(binding.image)

            binding.root.setOnClickListener {
                callback.onItemStoryClick(item)
            }
        }

        override fun clear() {
            binding.image.setImageResource(R.drawable.ic_image)
        }
    }

    interface CallBack {
        fun onItemStoryClick(item: Story)
    }
}