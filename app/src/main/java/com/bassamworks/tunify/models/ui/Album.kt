package com.bassamworks.tunify.models.ui

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType

data class Album(val id: Long,
                 var name: String = MediaStoreConstants.DEFAULT_ALBUM_NAME,
                 var albumArt: String = MediaStoreConstants.DEFAULT_ALBUM_ART,
                 var artist: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                 var firstYear: Int = MediaStoreConstants.DEFAULT_FIRST_YEAR,
                 var lastYear: Int = MediaStoreConstants.DEFAULT_LAST_YEAR,
                 var numberOfTracks: Int = MediaStoreConstants.DEFAULT_NUMBER_OF_SONGS) : IModelType.UI