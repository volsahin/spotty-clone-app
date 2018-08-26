package com.volcaniccoder.spotty.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }

}