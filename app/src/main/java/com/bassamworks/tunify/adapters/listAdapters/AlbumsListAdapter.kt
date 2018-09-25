package com.bassamworks.tunify.adapters.listAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bassamworks.tunify.databinding.ItemGridAlbumBinding
import com.bassamworks.tunify.models.ui.Album
import com.bassamworks.tunify.viewHolders.AlbumViewHolder

class AlbumsListAdapter : LibraryListAdapter<Album, AlbumViewHolder>(DiffCallbacks()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(ItemGridAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onItemSelected(model: Album) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class DiffCallbacks : DifferenceCallbacks<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.id == newItem.id
        }

    }
}