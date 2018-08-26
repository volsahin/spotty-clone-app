package com.volcaniccoder.spotty.library

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class LibraryViewModelFactory @Inject constructor(val repository: LibraryRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LibraryViewModel(repository) as T
    }

}