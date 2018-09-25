package com.bassamworks.tunify.fragments.libraryFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.listAdapters.SongsListAdapter
import com.bassamworks.tunify.models.ui.Song
import com.bassamworks.tunify.viewModels.library.SongsViewModel
import kotlinx.android.synthetic.main.fragment_all_songs.*


class SongsFragment : LibraryFragment() {

    private lateinit var model: SongsViewModel
    private val rvAdapter = SongsListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_all_songs, container, false)

        model = ViewModelProviders.of(this)[SongsViewModel::class.java]

        model.getLiveData().observe(this, Observer<List<Song>> {
            updateAdapter(it ?: listOf())
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_all_songs.adapter = rvAdapter
    }

    private fun updateAdapter(songs: List<Song>) {
        rvAdapter.submitList(songs)
    }
}
