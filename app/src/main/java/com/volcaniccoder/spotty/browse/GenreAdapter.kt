package com.volcaniccoder.spotty.browse

import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.databinding.ItemGenreBinding
import com.volcaniccoder.spotty.helper.DefaultDiffUtil

class GenreAdapter : ListAdapter<Genre, GenreAdapter.ViewHolder>(DefaultDiffUtil<Genre>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemGenreBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_genre, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: ItemGenreBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Genre) {
            itemBinding.item = item
            itemBinding.executePendingBindings()
        }
    }

}