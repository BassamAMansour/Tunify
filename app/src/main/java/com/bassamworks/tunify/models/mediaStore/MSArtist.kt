package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants

data class MSArtist(val artist: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                    val numberOfAlbums: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_ALBUMS,
                    val numberOfTracks: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_SONGS)