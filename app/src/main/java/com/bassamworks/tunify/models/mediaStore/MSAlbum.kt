package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants

data class MSAlbum(val album: String = MediaStoreConstants.DEFAULT_ALBUM_NAME,
                   val albumArt: String = MediaStoreConstants.DEFAULT_ALBUM_ART,
                   val albumId: Long = MediaStoreConstants.DEFAULT_ALBUM_ID,
                   val artist: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                   val firstYear: Int = MediaStoreConstants.DEFAULT_FIRST_YEAR,
                   val lastYear: Int = MediaStoreConstants.DEFAULT_LAST_YEAR,
                   val numberOfSongs: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_SONGS)