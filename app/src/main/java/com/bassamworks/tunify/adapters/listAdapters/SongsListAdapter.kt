package com.bassamworks.tunify.adapters.listAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bassamworks.tunify.databinding.ItemListSongBinding
import com.bassamworks.tunify.models.ui.Song
import com.bassamworks.tunify.viewHolders.SongViewHolder

class SongsListAdapter : LibraryListAdapter<Song, SongViewHolder>(DiffCallbacks()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(ItemListSongBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onItemSelected(model: Song) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class DiffCallbacks : DifferenceCallbacks<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.id == newItem.id
        }
    }
}