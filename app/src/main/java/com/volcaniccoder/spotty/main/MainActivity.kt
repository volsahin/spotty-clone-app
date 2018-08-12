package com.volcaniccoder.spotty.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.home.HomeFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)
        supportFragmentManager.beginTransaction().add(R.id.activity_main, HomeFragment()).commit()
    }

}
