package com.volcaniccoder.spotty.helper.commonmusiclist

import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.databinding.ItemCommonRowBinding
import com.volcaniccoder.spotty.helper.DefaultDiffUtil

class CommonMusicListAdapter : ListAdapter<CommonMusicItem, CommonMusicListAdapter.ViewHolder>(DefaultDiffUtil<CommonMusicItem>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemCommonRowBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_common_row, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: ItemCommonRowBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: CommonMusicItem) {
            itemBinding.item = item
            itemBinding.executePendingBindings()
        }
    }

}