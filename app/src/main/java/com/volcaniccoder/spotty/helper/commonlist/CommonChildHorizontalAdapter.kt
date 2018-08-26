package com.volcaniccoder.spotty.helper.commonlist

import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.databinding.ItemLabelBinding
import com.volcaniccoder.spotty.helper.DefaultDiffUtil
import com.volcaniccoder.spotty.helper.commonmusiclist.CommonMusicItem

class CommonChildHorizontalAdapter : ListAdapter<CommonMusicItem, CommonChildHorizontalAdapter.ViewHolder>(DefaultDiffUtil<CommonMusicItem>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemLabelBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_label, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: ItemLabelBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: CommonMusicItem) {
            itemBinding.item = item
            itemBinding.executePendingBindings()
        }
    }

}