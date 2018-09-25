package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType
import com.bassamworks.tunify.models.ui.Artist

data class MSArtist(val id: Long,
                    val name: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                    val numberOfAlbums: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_ALBUMS,
                    val numberOfTracks: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_SONGS) : IModelType.MediaStore {
    fun toUIModel(): Artist = Artist(id, name, numberOfAlbums, numberOfTracks)
}