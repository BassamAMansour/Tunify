package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType
import com.bassamworks.tunify.models.ui.Genre

data class MSGenre(val id: Long,
                   val genre: String = MediaStoreConstants.DEFAULT_GENRE) : IModelType.MediaStore {

    fun toUIModel(): Genre = Genre(id, genre)
}

