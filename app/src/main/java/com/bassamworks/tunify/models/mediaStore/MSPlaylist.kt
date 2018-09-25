package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType
import com.bassamworks.tunify.models.ui.Playlist

data class MSPlaylist(val id: Long,
                      val name: String = MediaStoreConstants.DEFAULT_PLAYLIST_NAME,
                      val playlistFilePath: String = MediaStoreConstants.DEFAULT_PLAYLIST_PATH,
                      val playlistDateAdded: Long = MediaStoreConstants.DEFAULT_PLAYLIST_DATE_ADDED,
                      val playlistDateModified: Long = MediaStoreConstants.DEFAULT_PLAYLIST_DATE_MODIFIED) : IModelType.MediaStore {
    fun toUIModel(): Playlist = Playlist(id, name)
}

