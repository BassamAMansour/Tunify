package com.bassamworks.tunify.fragments.libraryFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.listAdapters.GenresListAdapter
import com.bassamworks.tunify.models.ui.Genre
import com.bassamworks.tunify.viewModels.library.GenresViewModel
import kotlinx.android.synthetic.main.fragment_genres.*


class GenresFragment : LibraryFragment() {

    private lateinit var model: GenresViewModel
    private val rvAdapter = GenresListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_genres, container, false)

        model = ViewModelProviders.of(this)[GenresViewModel::class.java]

        model.getLiveData().observe(this, Observer<List<Genre>> {
            updateAdapter(it ?: listOf())
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_all_genres.adapter = rvAdapter
    }

    private fun updateAdapter(genres: List<Genre>) {
        rvAdapter.submitList(genres)
    }

}
