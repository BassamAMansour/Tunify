package com.bassamworks.tunify.fragments.libraryFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.listAdapters.ArtistsListAdapter
import com.bassamworks.tunify.models.ui.Artist
import com.bassamworks.tunify.viewModels.library.ArtistsViewModel
import kotlinx.android.synthetic.main.fragment_artists.*


class ArtistsFragment : LibraryFragment() {

    private lateinit var model: ArtistsViewModel
    private val rvAdapter = ArtistsListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_artists, container, false)


        model = ViewModelProviders.of(this)[ArtistsViewModel::class.java]

        model.getLiveData().observe(this, Observer<List<Artist>> {
            updateAdapter(it ?: listOf())
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_all_artists.adapter = rvAdapter
    }

    private fun updateAdapter(artists: List<Artist>) {
        rvAdapter.submitList(artists)
    }


}
