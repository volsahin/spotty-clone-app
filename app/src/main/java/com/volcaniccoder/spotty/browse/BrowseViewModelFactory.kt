package com.volcaniccoder.spotty.browse

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class BrowseViewModelFactory @Inject constructor(val repository: BrowseRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BrowseViewModel(repository) as T
    }

}