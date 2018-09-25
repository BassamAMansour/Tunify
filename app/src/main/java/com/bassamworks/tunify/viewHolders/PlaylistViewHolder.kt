package com.bassamworks.tunify.viewHolders

import com.bassamworks.tunify.databinding.ItemListPlaylistBinding
import com.bassamworks.tunify.models.ui.Playlist

class PlaylistViewHolder(private val binding: ItemListPlaylistBinding) : LibraryItemViewHolder<Playlist>(binding.root) {

    override fun bindTo(model: Playlist) {
        binding.apply {
            playlist = model
            executePendingBindings()
        }
    }
}