package com.volcaniccoder.spotty.playlist

import com.volcaniccoder.spotty.helper.MockDataSource
import javax.inject.Inject

class PlaylistRepository @Inject constructor(private val mockDataSource: MockDataSource) {

    fun getPlaylistSongs() = mockDataSource.getPlaylistSongs()
}