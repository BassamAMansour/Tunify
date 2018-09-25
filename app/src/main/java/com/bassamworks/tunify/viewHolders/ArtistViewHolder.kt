package com.bassamworks.tunify.viewHolders

import com.bassamworks.tunify.databinding.ItemListArtistBinding
import com.bassamworks.tunify.models.ui.Artist

class ArtistViewHolder(private val binding: ItemListArtistBinding) : LibraryItemViewHolder<Artist>(binding.root) {

    override fun bindTo(model: Artist) {
        binding.apply {
            artist = model
            executePendingBindings()
        }
    }
}