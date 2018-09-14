package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants

data class MSPlaylist(val name: String = MediaStoreConstants.DEFAULT_PLAYLIST_NAME,
                      val playlistFilePath: String = MediaStoreConstants.DEFAULT_PLAYLIST_PATH,
                      val playlistDateAdded: Long = MediaStoreConstants.DEFAULT_PLAYLIST_DATE_ADDED,
                      val playlistDateModified: Long = MediaStoreConstants.DEFAULT_PLAYLIST_DATE_MODIFIED)