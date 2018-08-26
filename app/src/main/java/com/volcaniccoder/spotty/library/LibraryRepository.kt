package com.volcaniccoder.spotty.library

import com.volcaniccoder.spotty.helper.MockDataSource
import javax.inject.Inject

class LibraryRepository @Inject constructor(private val dataSource: MockDataSource) {

    fun getTopCategories() = dataSource.getLibrarySingleRowItems()
    fun getLibraryMidTitle() = dataSource.getLibraryMidTitle()
    fun getMusicItems() = dataSource.getCommonMusicItems()
}