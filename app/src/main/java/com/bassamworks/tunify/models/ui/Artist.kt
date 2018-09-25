package com.bassamworks.tunify.models.ui

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType

data class Artist(val id: Long,
                  var name: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                  var numberOfAlbums: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_ALBUMS,
                  var numberOfTracks: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_SONGS,
                  var imgUri: String = MediaStoreConstants.DEFAULT_ALBUM_ART) : IModelType.UI