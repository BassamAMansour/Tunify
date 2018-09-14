package com.bassamworks.tunify.fragments.libraryFragments


import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.cursorAdapters.PlaylistsCursorAdapter
import com.bassamworks.tunify.excutors.AppExecutors
import com.bassamworks.tunify.media.scanners.MediaStoreScanner
import kotlinx.android.synthetic.main.fragment_playlists.*

class PlaylistsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_playlists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllPlaylists(view.context)
    }

    private fun getAllPlaylists(context: Context) {
        AppExecutors.instance?.diskIO()?.execute {
            updateAdapter(context, MediaStoreScanner(context).getAllPlaylists())
        }
    }

    private fun updateAdapter(context: Context, cursor: Cursor) {
        lv_all_playlists.adapter = PlaylistsCursorAdapter(context, cursor)
    }

}
