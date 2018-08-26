package com.volcaniccoder.spotty.base

import android.content.Context
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView

@BindingAdapter("android:src")
fun ImageView.setImageViewResource(resource: Int) {
    this.setImageResource(resource)
    if (resource == 0) {
        this.hide()
    }
}

fun Int.dpToPx(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()

fun View.hide(){
    this.visibility = View.GONE
}

fun View.show(){
    this.visibility = View.VISIBLE
}