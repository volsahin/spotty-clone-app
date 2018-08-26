package com.volcaniccoder.spotty.helper

import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.base.ResourceProvider
import com.volcaniccoder.spotty.browse.Genre
import com.volcaniccoder.spotty.helper.commonlist.CommonViewItem
import com.volcaniccoder.spotty.helper.commonlist.Header
import com.volcaniccoder.spotty.helper.commonmusiclist.CommonMusicItem
import com.volcaniccoder.spotty.library.SingleRowItem
import java.util.*
import javax.inject.Inject

class MockDataSource @Inject constructor(private val resourceProvider: ResourceProvider) {

    fun getLibrarySingleRowItems(): ArrayList<SingleRowItem> = arrayListOf(
            SingleRowItem(R.drawable.ic_wb_sunny_black_24dp, resourceProvider.getString(R.string.for_you)),
            SingleRowItem(R.drawable.ic_music_note_black_24dp, resourceProvider.getString(R.string.playlists)),
            SingleRowItem(R.drawable.ic_radio_black_24dp, resourceProvider.getString(R.string.stations)),
            SingleRowItem(R.drawable.ic_music_note_black_24dp, resourceProvider.getString(R.string.songs)),
            SingleRowItem(R.drawable.ic_album_black_24dp, resourceProvider.getString(R.string.albums)),
            SingleRowItem(R.drawable.ic_person_outline_black_24dp, resourceProvider.getString(R.string.artists)),
            SingleRowItem(R.drawable.ic_radio_black_24dp, resourceProvider.getString(R.string.podcasts)))

    fun getGenreList() = arrayListOf(
            Genre("Hard Rock"),
            Genre("Heavy Metal"),
            Genre("Blues"),
            Genre("Pop"),
            Genre("Hard Rock"),
            Genre("Heavy Metal"),
            Genre("Blues"),
            Genre("Pop"),
            Genre("Hard Rock"),
            Genre("Heavy Metal"),
            Genre("Blues"),
            Genre("Pop"),
            Genre("Hard Rock"),
            Genre("Heavy Metal"),
            Genre("Blues"),
            Genre("Pop"),
            Genre("Hard Rock " + "\nHard"),
            Genre("Heavy Metal"),
            Genre("Blues"),
            Genre("Pop"),
            Genre("Hard Rock"),
            Genre("Heavy Metal"),
            Genre("Blues"),
            Genre("Pop"))

    fun getBrowsePageHeader() = arrayListOf(
            CommonViewItem(
                    Header(resourceProvider.getString(R.string.sunday_message), ""),
                    getCommonMusicItems())
    )

    private val musicItems = arrayOf(
            CommonMusicItem(R.drawable.ic_rocker, "Gees Bees", "Aliving Still"),
            CommonMusicItem(R.drawable.ic_rapper, "Xeminem", "Some Fast Words"),
            CommonMusicItem(R.drawable.ic_musician, "Jon Bovi", "Living on a App"),
            CommonMusicItem(R.drawable.ic_classic_musician, "Hoffen", "Serenade of Chocolate"))

    fun getHomePageData() = arrayListOf(
            CommonViewItem(
                    Header(resourceProvider.getString(R.string.made_for_user), resourceProvider.getString(R.string.get_better_recommendation)),
                    getCommonMusicItems()),
            CommonViewItem(
                    Header(resourceProvider.getString(R.string.jump_back_in), resourceProvider.getString(R.string.get_better_recommendation)),
                    getCommonMusicItems()),
            CommonViewItem(
                    Header(resourceProvider.getString(R.string.recently_played), ""),
                    getCommonMusicItems()))


    fun getLibraryMidTitle() = Header(resourceProvider.getString(R.string.recently_played), "")

    fun getCommonMusicItems(): ArrayList<CommonMusicItem> {

        val musicItemList = arrayListOf<CommonMusicItem>()
        val random = Random()
        for (i in 0..20) {
            musicItemList.add(musicItems[random.nextInt(4)])
        }
        return musicItemList
    }

    fun getSearchHistoryItems(): ArrayList<CommonMusicItem> {
        val musicItemList = arrayListOf<CommonMusicItem>()
        val random = Random()
        for (i in 0..20) {
            val musicItem = musicItems[random.nextInt(4)]
            musicItem.isDelete = true
            musicItemList.add(musicItem)
        }

        return musicItemList
    }

    fun getPlaylistSongs(): ArrayList<CommonMusicItem> {
        val musicItemList = arrayListOf<CommonMusicItem>()
        val random = Random()
        for (i in 0..20) {
            val musicItem = musicItems[random.nextInt(4)]
            musicItem.icon = 0
            musicItem.showDownloadIcon = true
            musicItemList.add(musicItem)
        }

        return musicItemList
    }


}