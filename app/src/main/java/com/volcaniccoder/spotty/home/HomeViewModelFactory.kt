package com.volcaniccoder.spotty.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class HomeViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel() as T
    }

}