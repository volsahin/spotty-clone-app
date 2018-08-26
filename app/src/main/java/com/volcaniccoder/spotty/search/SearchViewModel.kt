package com.volcaniccoder.spotty.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.volcaniccoder.spotty.helper.commonmusiclist.CommonMusicItem

class SearchViewModel(val repository: SearchRepository) : ViewModel() {

    val searchHistoryLiveData = MutableLiveData<ArrayList<CommonMusicItem>>()

    init {
        getSearchHistory()
    }

    private fun getSearchHistory() {
        searchHistoryLiveData.postValue(repository.getSearchHistoryItems())
    }
}