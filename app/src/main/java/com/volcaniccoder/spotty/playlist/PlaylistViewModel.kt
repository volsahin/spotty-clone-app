package com.volcaniccoder.spotty.playlist

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.volcaniccoder.spotty.helper.commonmusiclist.CommonMusicItem

class PlaylistViewModel(val repository: PlaylistRepository): ViewModel() {

    val playlistSongsLiveData = MutableLiveData<ArrayList<CommonMusicItem>>()

    init {
        getPlaylistSongs()
    }

    private fun getPlaylistSongs() {
        playlistSongsLiveData.postValue(repository.getPlaylistSongs())
    }
}