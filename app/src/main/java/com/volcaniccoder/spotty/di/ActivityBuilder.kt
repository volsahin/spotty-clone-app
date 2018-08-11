package com.volcaniccoder.spotty.di

import com.volcaniccoder.spotty.main.MainActivity
import com.volcaniccoder.spotty.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}