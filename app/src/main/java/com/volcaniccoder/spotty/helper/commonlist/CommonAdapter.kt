package com.volcaniccoder.spotty.helper.commonlist

import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.base.dpToPx
import com.volcaniccoder.spotty.databinding.ItemHomeBinding
import com.volcaniccoder.spotty.helper.DefaultDiffUtil
import com.volcaniccoder.spotty.helper.EdgeDecorator

class CommonAdapter : ListAdapter<CommonViewItem, CommonAdapter.ViewHolder>(DefaultDiffUtil<CommonViewItem>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemHomeBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_home, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: ItemHomeBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: CommonViewItem) {
            itemBinding.layoutHomeTitle?.titleTop?.text = item.header.title

            if (item.header.subTitle.isEmpty()) {
                itemBinding.layoutHomeTitle?.titleBottom?.visibility = View.GONE
            } else {
                itemBinding.layoutHomeTitle?.titleBottom?.text = item.header.subTitle
            }


            itemBinding.labelItemList.addItemDecoration(EdgeDecorator(16.dpToPx(itemBinding.root.context), EdgeDecorator.LayoutManagerType.TYPE_LINEAR))
            itemBinding.labelItemList.layoutManager = LinearLayoutManager(itemBinding.root.context, LinearLayoutManager.HORIZONTAL, false)
            val adapter = CommonChildHorizontalAdapter()
            adapter.submitList(item.label)
            itemBinding.labelItemList.adapter = adapter
            itemBinding.executePendingBindings()
        }
    }


}