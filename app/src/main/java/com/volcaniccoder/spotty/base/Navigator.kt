package com.volcaniccoder.spotty.base

import android.support.v4.app.FragmentActivity
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.browse.BrowseFragment
import com.volcaniccoder.spotty.home.HomeFragment
import com.volcaniccoder.spotty.library.LibraryFragment
import com.volcaniccoder.spotty.playlist.PlaylistFragment
import com.volcaniccoder.spotty.search.SearchFragment

class Navigator {

    fun navigateToHome(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
    }

    fun navigateToBrowse(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, BrowseFragment()).commit()
    }

    fun navigateToSearch(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SearchFragment()).commit()
    }

    fun navigateToRadio(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
    }

    fun navigateToLibrary(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LibraryFragment()).commit()
    }

    fun navigateToPlaylist(activity: FragmentActivity) {
        activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, PlaylistFragment()).commit()
    }
}