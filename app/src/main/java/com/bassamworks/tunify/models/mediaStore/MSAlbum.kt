package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType
import com.bassamworks.tunify.models.ui.Album

data class MSAlbum(val id: Long,
                   val name: String = MediaStoreConstants.DEFAULT_ALBUM_NAME,
                   val albumArt: String = MediaStoreConstants.DEFAULT_ALBUM_ART,
                   val albumId: Long = MediaStoreConstants.DEFAULT_ALBUM_ID,
                   val artist: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                   val firstYear: Int = MediaStoreConstants.DEFAULT_FIRST_YEAR,
                   val lastYear: Int = MediaStoreConstants.DEFAULT_LAST_YEAR,
                   val numberOfTracks: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_SONGS) : IModelType.MediaStore {

    fun toUIModel(): Album = Album(id, name, albumArt, artist, firstYear, lastYear, numberOfTracks)
}

