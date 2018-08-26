package com.volcaniccoder.spotty.library

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.volcaniccoder.spotty.helper.commonlist.Header
import com.volcaniccoder.spotty.helper.commonmusiclist.CommonMusicItem

class LibraryViewModel(private val repository: LibraryRepository) : ViewModel() {

    val topCategoriesLiveData = MutableLiveData<ArrayList<SingleRowItem>>()
    val middleHeaderLiveData = MutableLiveData<Header>()
    val bottomListLiveData = MutableLiveData<ArrayList<CommonMusicItem>>()

    init {
        getTopCategories()
        getLibraryMidTitle()
        getMusicItems()
    }

    private fun getTopCategories() = topCategoriesLiveData.postValue(repository.getTopCategories())

    private fun getLibraryMidTitle() = middleHeaderLiveData.postValue(repository.getLibraryMidTitle())

    private fun getMusicItems() = bottomListLiveData.postValue(repository.getMusicItems())
}