package com.volcaniccoder.spotty.di

import com.volcaniccoder.spotty.browse.BrowseFragment
import com.volcaniccoder.spotty.browse.BrowseFragmentModule
import com.volcaniccoder.spotty.home.HomeFragment
import com.volcaniccoder.spotty.home.HomeFragmentModule
import com.volcaniccoder.spotty.library.LibraryFragment
import com.volcaniccoder.spotty.library.LibraryFragmentModule
import com.volcaniccoder.spotty.main.MainActivity
import com.volcaniccoder.spotty.main.MainActivityModule
import com.volcaniccoder.spotty.playlist.PlaylistFragment
import com.volcaniccoder.spotty.playlist.PlaylistFragmentModule
import com.volcaniccoder.spotty.search.SearchFragment
import com.volcaniccoder.spotty.search.SearchFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(HomeFragmentModule::class)])
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [(BrowseFragmentModule::class)])
    abstract fun bindBrowseFragment(): BrowseFragment

    @ContributesAndroidInjector(modules = [(SearchFragmentModule::class)])
    abstract fun bindSearchFragment(): SearchFragment

    @ContributesAndroidInjector(modules = [(LibraryFragmentModule::class)])
    abstract fun bindLibraryFragment(): LibraryFragment

    @ContributesAndroidInjector(modules = [(PlaylistFragmentModule::class)])
    abstract fun bindPlaylistFragment(): PlaylistFragment

}