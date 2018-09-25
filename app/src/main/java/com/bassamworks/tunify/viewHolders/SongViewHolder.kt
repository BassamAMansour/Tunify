package com.bassamworks.tunify.viewHolders

import com.bassamworks.tunify.databinding.ItemListSongBinding
import com.bassamworks.tunify.models.ui.Song

class SongViewHolder(private val binding: ItemListSongBinding) : LibraryItemViewHolder<Song>(binding.root) {


    override fun bindTo(model: Song) {
        binding.apply {
            song = model
            executePendingBindings()
        }
    }
}