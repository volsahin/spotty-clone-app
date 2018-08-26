package com.volcaniccoder.spotty.browse

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.helper.EdgeDecorator
import com.volcaniccoder.spotty.helper.commonlist.CommonAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_browse.*
import javax.inject.Inject

class BrowseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: BrowseViewModelFactory

    private lateinit var viewModel: BrowseViewModel

    private lateinit var headerListAdapter : CommonAdapter

    private lateinit var genreAdapter: GenreAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(BrowseViewModel::class.java)
        headerListAdapter = CommonAdapter()
        genreAdapter = GenreAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_browse, container, false)
        viewModel.browseHeaderListData.observe(this, Observer { headerListAdapter.submitList(it) })
        viewModel.genreLiveData.observe(this, Observer { genreAdapter.submitList(it) })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        browse_head_recycler_view.adapter = headerListAdapter
        browse_head_recycler_view.isNestedScrollingEnabled = false
        browse_genre_recycler_view.addItemDecoration(EdgeDecorator(16,EdgeDecorator.LayoutManagerType.TYPE_GRID))
        browse_genre_recycler_view.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        browse_genre_recycler_view.adapter = genreAdapter
        browse_genre_recycler_view.isNestedScrollingEnabled = false
    }

}