package com.bassamworks.tunify.adapters.listAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bassamworks.tunify.databinding.ItemListArtistBinding
import com.bassamworks.tunify.models.ui.Artist
import com.bassamworks.tunify.viewHolders.ArtistViewHolder

class ArtistsListAdapter : LibraryListAdapter<Artist, ArtistViewHolder>(DiffCallbacks()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        return ArtistViewHolder(ItemListArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onItemSelected(model: Artist) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class DiffCallbacks : DifferenceCallbacks<Artist>() {
        override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem.id == newItem.id
        }
    }
}