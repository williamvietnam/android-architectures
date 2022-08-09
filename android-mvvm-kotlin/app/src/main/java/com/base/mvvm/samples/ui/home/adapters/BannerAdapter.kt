package com.base.mvvm.samples.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.mvvm.R
import com.base.mvvm.databinding.ItemBannerSampleBinding
import com.base.mvvm.samples.models.Banner

class BannerAdapter(private val banners: List<Banner>, private val callback: CallBack) :
    RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            ItemBannerSampleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    inner class BannerViewHolder(private val binding: ItemBannerSampleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val item: Banner = banners[position]
            binding.root.setOnClickListener {
                callback.onClick(item)
            }
        }

        fun clear() {
            binding.itemBanner.setImageResource(R.drawable.ic_image)
        }
    }

    interface CallBack {
        fun condition(position: Int, fullSize: Int)

        fun onClick(item: Banner)
    }
}