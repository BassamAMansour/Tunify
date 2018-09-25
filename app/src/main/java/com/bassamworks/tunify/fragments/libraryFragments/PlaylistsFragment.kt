package com.bassamworks.tunify.fragments.libraryFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.listAdapters.PlaylistsListAdapter
import com.bassamworks.tunify.models.ui.Playlist
import com.bassamworks.tunify.viewModels.library.PlaylistsViewModel
import kotlinx.android.synthetic.main.fragment_playlists.*

class PlaylistsFragment : LibraryFragment() {

    private lateinit var model: PlaylistsViewModel
    private val rvAdapter = PlaylistsListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_playlists, container, false)

        model = ViewModelProviders.of(this)[PlaylistsViewModel::class.java]

        model.getLiveData().observe(this, Observer<List<Playlist>> {
            updateAdapter(it ?: listOf())
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_all_playlists.adapter = rvAdapter
    }

    private fun updateAdapter(playlists: List<Playlist>) {
        rvAdapter.submitList(playlists)
    }
}
