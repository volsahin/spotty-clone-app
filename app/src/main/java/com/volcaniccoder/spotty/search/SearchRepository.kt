package com.volcaniccoder.spotty.search

import com.volcaniccoder.spotty.helper.MockDataSource
import javax.inject.Inject

class SearchRepository @Inject constructor(private val dataSource: MockDataSource) {

    fun getSearchHistoryItems() = dataSource.getSearchHistoryItems()
}