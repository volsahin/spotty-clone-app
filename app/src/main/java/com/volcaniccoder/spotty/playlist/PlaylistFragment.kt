package com.volcaniccoder.spotty.playlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.helper.commonmusiclist.CommonMusicListAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_playlist.*
import javax.inject.Inject

class PlaylistFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: PlaylistViewModelFactory

    private lateinit var viewModel: PlaylistViewModel

    private lateinit var playlistAdapter : CommonMusicListAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PlaylistViewModel::class.java)
        playlistAdapter = CommonMusicListAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)
        viewModel.playlistSongsLiveData.observe(this, Observer { playlistAdapter.submitList(it) })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playlist_recycler_view.adapter = playlistAdapter
    }
}