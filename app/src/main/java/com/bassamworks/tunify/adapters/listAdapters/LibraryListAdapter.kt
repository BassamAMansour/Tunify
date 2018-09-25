package com.bassamworks.tunify.adapters.listAdapters

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bassamworks.tunify.models.IModelType
import com.bassamworks.tunify.viewHolders.LibraryItemViewHolder

abstract class LibraryListAdapter<ModelType : IModelType.UI,
        VH : LibraryItemViewHolder<ModelType>>(diffCallbacks: DifferenceCallbacks<ModelType>)
    : ListAdapter<ModelType, VH>(diffCallbacks) {

    abstract class DifferenceCallbacks<ModelType> : DiffUtil.ItemCallback<ModelType>() {
        override fun areContentsTheSame(oldItem: ModelType, newItem: ModelType): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener { onItemSelected(getItem(position)) }
        holder.bindTo(getItem(position))
    }

    protected abstract fun onItemSelected(model: ModelType)
}