package com.bassamworks.tunify.viewHolders

import com.bassamworks.tunify.databinding.ItemGridAlbumBinding
import com.bassamworks.tunify.models.ui.Album

class AlbumViewHolder(private val binding: ItemGridAlbumBinding) : LibraryItemViewHolder<Album>(binding.root) {

    override fun bindTo(model: Album) {
        binding.apply {
            album = model
            executePendingBindings()
        }
    }
}