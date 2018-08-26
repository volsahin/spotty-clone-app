package com.volcaniccoder.spotty.playlist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class PlaylistViewModelFactory @Inject constructor(val repository: PlaylistRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlaylistViewModel(repository) as T
    }

}