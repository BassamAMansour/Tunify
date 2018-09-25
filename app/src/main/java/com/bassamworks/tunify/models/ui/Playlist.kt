package com.bassamworks.tunify.models.ui

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType

data class Playlist(val id: Long,
                    var name: String = MediaStoreConstants.DEFAULT_PLAYLIST_NAME,
                    var tracks: Int = 1) : IModelType.UI