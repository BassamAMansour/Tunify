package com.bassamworks.tunify.viewHolders

import android.view.View
import com.bassamworks.tunify.models.IModelType

abstract class LibraryItemViewHolder<ModelType : IModelType.UI>(itemView: View)
    : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
    abstract fun bindTo(model: ModelType)
}