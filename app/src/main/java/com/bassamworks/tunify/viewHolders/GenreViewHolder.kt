package com.bassamworks.tunify.viewHolders

import com.bassamworks.tunify.databinding.ItemListGenreBinding
import com.bassamworks.tunify.models.ui.Genre

class GenreViewHolder(private val binding: ItemListGenreBinding) : LibraryItemViewHolder<Genre>(binding.root) {

    override fun bindTo(model: Genre) {
        binding.apply {
            genre = model
            executePendingBindings()
        }
    }
}