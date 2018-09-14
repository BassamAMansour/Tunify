package com.bassamworks.tunify.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.pagerAdapters.LibraryPagerAdapter

class LibraryFragment : Fragment() {

    companion object {
        const val KEY_FRAGMENT_POSITION = "fragment_position"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val fragmentPosition = arguments?.getInt(KEY_FRAGMENT_POSITION, LibraryPagerAdapter.POSITION_FRAGMENT_PLAYLISTS)

        val view = inflater.inflate(R.layout.fragment_library, container, false)

        view.findViewById<ViewPager>(R.id.view_pager_library).apply {
            adapter = LibraryPagerAdapter(context, childFragmentManager)
            fragmentPosition?.let { setCurrentItem(it, true) }
        }

        return view
    }
}

