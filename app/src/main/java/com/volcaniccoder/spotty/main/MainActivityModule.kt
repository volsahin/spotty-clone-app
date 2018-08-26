package com.volcaniccoder.spotty.main

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModelFactory() = MainViewModelFactory()
}