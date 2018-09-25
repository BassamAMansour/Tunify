package com.bassamworks.tunify.adapters.listAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bassamworks.tunify.databinding.ItemListPlaylistBinding
import com.bassamworks.tunify.models.ui.Playlist
import com.bassamworks.tunify.viewHolders.PlaylistViewHolder

class PlaylistsListAdapter : LibraryListAdapter<Playlist, PlaylistViewHolder>(DiffCallbacks()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemListPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onItemSelected(model: Playlist) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class DiffCallbacks : DifferenceCallbacks<Playlist>() {
        override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem.id == newItem.id
        }
    }
}