package com.volcaniccoder.spotty.helper

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class EdgeDecorator(private val margin: Int, private val layoutType : LayoutManagerType) : RecyclerView.ItemDecoration() {

    enum class LayoutManagerType(type: Int) {
        TYPE_LINEAR(0), TYPE_GRID(1)
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemCount = state!!.itemCount

        val itemPosition = parent?.getChildAdapterPosition(view)

        if (layoutType == LayoutManagerType.TYPE_LINEAR) {
            if (itemCount > 0 && itemPosition == itemCount - 1) {
                outRect?.set(view!!.paddingLeft, view.paddingTop, margin, view.paddingBottom)
            }
        } else if (layoutType == LayoutManagerType.TYPE_GRID) {
            if (itemCount > 0 && itemPosition?.rem(2) != 0) {
                outRect?.set(view!!.paddingLeft, view.paddingTop, margin, view.paddingBottom)
            }
        }

    }
}