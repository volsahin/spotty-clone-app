package com.volcaniccoder.spotty.library

import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.databinding.ItemLibraryTopCategoriesBinding
import com.volcaniccoder.spotty.helper.DefaultDiffUtil

class LibraryTopCategoriesAdapter(private val listener: OnClickListener) :
        ListAdapter<SingleRowItem, LibraryTopCategoriesAdapter.ViewHolder>(DefaultDiffUtil<SingleRowItem>()) {

    interface OnClickListener {
        fun onItemClicked(view: View, item: SingleRowItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemLibraryTopCategoriesBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_library_top_categories, parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: ItemLibraryTopCategoriesBinding,
                     private val listener: OnClickListener) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: SingleRowItem) {
            itemBinding.item = item
            itemBinding.listener = listener
            itemBinding.executePendingBindings()
        }
    }

}