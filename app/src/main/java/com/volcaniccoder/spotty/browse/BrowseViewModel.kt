package com.volcaniccoder.spotty.browse

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.volcaniccoder.spotty.helper.commonlist.CommonViewItem

class BrowseViewModel constructor(private val repository: BrowseRepository) : ViewModel() {

    val browseHeaderListData = MutableLiveData<ArrayList<CommonViewItem>>()
    val genreLiveData = MutableLiveData<ArrayList<Genre>>()

    init {
        getBrowseHeader()
        getGenres()
    }

    private fun getBrowseHeader() {
        browseHeaderListData.postValue(repository.getBrowsePageHeader())
    }

    private fun getGenres() {
        genreLiveData.postValue(repository.getGenreData())
    }
}