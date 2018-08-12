package com.volcaniccoder.spotty.home

import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun provideHomeViewModelFactory() = HomeViewModelFactory()
}