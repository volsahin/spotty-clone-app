package com.volcaniccoder.spotty.base

import android.content.Context
import javax.inject.Inject

class ResourceProvider @Inject constructor(val context: Context) {

    fun getString(resourceId: Int): String = context.getString(resourceId)

}