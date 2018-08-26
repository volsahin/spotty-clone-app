package com.volcaniccoder.spotty.home

import com.volcaniccoder.spotty.helper.MockDataSource
import javax.inject.Inject

class HomeRepository @Inject constructor(private val mockDataSource: MockDataSource) {

    fun getHomeData() = mockDataSource.getHomePageData()
}