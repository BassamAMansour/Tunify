package com.bassamworks.tunify.fragments.libraryFragments


import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.cursorAdapters.SongsCursorAdapter
import com.bassamworks.tunify.excutors.AppExecutors
import com.bassamworks.tunify.media.scanners.MediaStoreScanner
import kotlinx.android.synthetic.main.fragment_all_songs.*


class AllSongsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllSongs(view.context)
    }

    private fun getAllSongs(context: Context) {
        AppExecutors.instance?.diskIO()?.execute {
            updateAdapter(context, MediaStoreScanner(context).getAllSongs())
        }
    }

    private fun updateAdapter(context: Context, cursor: Cursor) {
        lv_all_songs.adapter = SongsCursorAdapter(context, cursor)
    }

}
