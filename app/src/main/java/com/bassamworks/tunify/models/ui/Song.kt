package com.bassamworks.tunify.models.ui

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType

data class Song(val id: Long,
                val filePath: String,
                var title: String = MediaStoreConstants.DEFAULT_TITLE,
                var album: String = MediaStoreConstants.DEFAULT_ALBUM_NAME,
                var artist: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                var length: Double,
                var progress: Double = 0.0,
                var imgUri: String = MediaStoreConstants.DEFAULT_ALBUM_ART) : IModelType.UI

