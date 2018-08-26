package com.volcaniccoder.spotty.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.volcaniccoder.spotty.helper.commonlist.CommonViewItem

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val homeLiveData = MutableLiveData<ArrayList<CommonViewItem>>()

    init {
        getHomeData()
    }

    private fun getHomeData() {
        homeLiveData.postValue(repository.getHomeData())
    }
}