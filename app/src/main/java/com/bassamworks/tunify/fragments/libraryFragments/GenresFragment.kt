package com.bassamworks.tunify.fragments.libraryFragments


import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.cursorAdapters.GenresCursorAdapter
import com.bassamworks.tunify.excutors.AppExecutors
import com.bassamworks.tunify.media.scanners.MediaStoreScanner
import kotlinx.android.synthetic.main.fragment_genres.*


class GenresFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_genres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllGenres(view.context)
    }

    private fun getAllGenres(context: Context) {
        AppExecutors.instance?.diskIO()?.execute {
            updateAdapter(context, MediaStoreScanner(context).getAllGenres())
        }
    }

    private fun updateAdapter(context: Context, cursor: Cursor) {
        lv_all_genres.adapter = GenresCursorAdapter(context, cursor)
    }

}
