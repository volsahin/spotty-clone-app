package com.volcaniccoder.spotty.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.volcaniccoder.bottomify.BottomifyNavigationView
import com.volcaniccoder.bottomify.OnNavigationItemChangeListener
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.base.Navigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel

    val navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)
        navigator.navigateToHome(this@MainActivity)
        setUpBottomify(findViewById(R.id.bottomify_nav))
    }

    private fun setUpBottomify(bottomify : BottomifyNavigationView) {
        bottomify.setOnNavigationItemChangedListener( object : OnNavigationItemChangeListener {
            override fun onNavigationItemChanged(navigationItem: BottomifyNavigationView.NavigationItem) {
                when(navigationItem.position) {
                    0 -> navigator.navigateToHome(this@MainActivity)
                    1 -> navigator.navigateToBrowse(this@MainActivity)
                    2 -> navigator.navigateToSearch(this@MainActivity)
                    // TODO : add navigateToRadio
                    4 -> navigator.navigateToLibrary(this@MainActivity)
                }
            }
        })
    }

}
