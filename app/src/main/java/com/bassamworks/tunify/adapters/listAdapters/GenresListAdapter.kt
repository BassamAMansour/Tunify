package com.bassamworks.tunify.adapters.listAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bassamworks.tunify.databinding.ItemListGenreBinding
import com.bassamworks.tunify.models.ui.Genre
import com.bassamworks.tunify.viewHolders.GenreViewHolder

class GenresListAdapter : LibraryListAdapter<Genre, GenreViewHolder>(DiffCallbacks()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(ItemListGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onItemSelected(model: Genre) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class DiffCallbacks : DifferenceCallbacks<Genre>() {
        override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem.id == newItem.id
        }

    }
}