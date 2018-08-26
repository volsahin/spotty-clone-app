package com.volcaniccoder.spotty.library

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.volcaniccoder.spotty.R
import com.volcaniccoder.spotty.base.hide
import com.volcaniccoder.spotty.helper.commonmusiclist.CommonMusicListAdapter
import com.volcaniccoder.spotty.main.MainActivity
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_library.*
import javax.inject.Inject

class LibraryFragment : Fragment(), LibraryTopCategoriesAdapter.OnClickListener {

    @Inject
    lateinit var viewModelFactory: LibraryViewModelFactory

    private lateinit var viewModel: LibraryViewModel

    private lateinit var topListAdapter : LibraryTopCategoriesAdapter

    private lateinit var bottomListAdapter : CommonMusicListAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LibraryViewModel::class.java)
        topListAdapter = LibraryTopCategoriesAdapter(this)
        bottomListAdapter = CommonMusicListAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_library, container, false)
        viewModel.topCategoriesLiveData.observe(this, Observer { topListAdapter.submitList(it) })
        viewModel.bottomListLiveData.observe(this, Observer { bottomListAdapter.submitList(it) })
        viewModel.middleHeaderLiveData.observe(this, Observer {
            val midTitleView = view.findViewById<ConstraintLayout>(R.id.library_mid_title)
            midTitleView.findViewById<TextView>(R.id.title_top).text = it?.title
            midTitleView.findViewById<TextView>(R.id.title_bottom).hide()
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        library_top_list.adapter = topListAdapter
        library_top_list.isNestedScrollingEnabled = false
        library_bottom_list.adapter = bottomListAdapter
        library_bottom_list.isNestedScrollingEnabled = false
    }

    override fun onItemClicked(view: View, item: SingleRowItem) {
        // Just a dummy check for item
        if (item.title == getString(R.string.songs))
            (activity as MainActivity).navigator.navigateToPlaylist(activity as FragmentActivity)
        else
            Toast.makeText(context,"Not ready. Click 'Songs'",Toast.LENGTH_SHORT).show()
    }
}