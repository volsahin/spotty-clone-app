package com.volcaniccoder.spotty.browse

import com.volcaniccoder.spotty.helper.MockDataSource
import javax.inject.Inject

class BrowseRepository @Inject constructor(private val mockDataSource: MockDataSource) {

    fun getBrowsePageHeader() = mockDataSource.getBrowsePageHeader()
    fun getGenreData() = mockDataSource.getGenreList()
}