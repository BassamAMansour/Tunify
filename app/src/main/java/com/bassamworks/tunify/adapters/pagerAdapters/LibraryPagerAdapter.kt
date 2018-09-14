package com.bassamworks.tunify.adapters.pagerAdapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.bassamworks.tunify.R
import com.bassamworks.tunify.fragments.libraryFragments.*

class LibraryPagerAdapter(private val context: Context?,
                          fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        const val NUMBER_OF_TABS = 5
        const val POSITION_FRAGMENT_PLAYLISTS = 0
        const val POSITION_FRAGMENT_ALL_SONGS = 1
        const val POSITION_FRAGMENT_ALBUMS = 2
        const val POSITION_FRAGMENT_ARTISTS = 3
        const val POSITION_FRAGMENT_GENRES = 4

    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            POSITION_FRAGMENT_PLAYLISTS -> PlaylistsFragment()
            POSITION_FRAGMENT_ALL_SONGS -> AllSongsFragment()
            POSITION_FRAGMENT_ALBUMS -> AlbumsFragment()
            POSITION_FRAGMENT_ARTISTS -> ArtistsFragment()
            POSITION_FRAGMENT_GENRES -> GenresFragment()
            else -> PlaylistsFragment()
        }
    }

    override fun getCount(): Int {
        return NUMBER_OF_TABS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            POSITION_FRAGMENT_PLAYLISTS -> context?.getString(R.string.playlists)
            POSITION_FRAGMENT_ALL_SONGS -> context?.getString(R.string.all_songs)
            POSITION_FRAGMENT_ALBUMS -> context?.getString(R.string.albums)
            POSITION_FRAGMENT_ARTISTS -> context?.getString(R.string.artists)
            POSITION_FRAGMENT_GENRES -> context?.getString(R.string.genres)
            else -> ""
        }
    }
}