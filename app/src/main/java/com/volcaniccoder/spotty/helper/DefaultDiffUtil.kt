package com.volcaniccoder.spotty.helper

import android.support.v7.util.DiffUtil

class DefaultDiffUtil<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = false

    override fun areContentsTheSame(oldItem: T, newItem: T) = false
}