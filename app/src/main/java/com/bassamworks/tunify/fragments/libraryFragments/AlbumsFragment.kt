package com.bassamworks.tunify.fragments.libraryFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.listAdapters.AlbumsListAdapter
import com.bassamworks.tunify.models.ui.Album
import com.bassamworks.tunify.viewModels.library.AlbumsViewModel
import kotlinx.android.synthetic.main.fragment_albums.*

class AlbumsFragment : LibraryFragment() {

    private lateinit var model: AlbumsViewModel
    private val rvAdapter = AlbumsListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_albums, container, false)

        model = ViewModelProviders.of(this)[AlbumsViewModel::class.java]

        model.getLiveData().observe(this, Observer<List<Album>> {
            updateAdapter(it ?: listOf())
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_all_albums.adapter = rvAdapter
    }

    private fun updateAdapter(albums: List<Album>) {
        rvAdapter.submitList(albums)
    }
}
