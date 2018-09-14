package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants

data class MSSong(override val filePath: String,
                  override val size: Long,
                  override val displayName: String,
                  override val title: String,
                  override val dateAdded: Long,
                  val duration: Long,
                  val album: String = MediaStoreConstants.DEFAULT_ALBUM_NAME,
                  val albumId: Long = MediaStoreConstants.DEFAULT_ALBUM_ID,
                  val artist: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                  val artistId: Long = MediaStoreConstants.DEFAULT_ARTIST_ID,
                  val lastPlaybackBookmark: Long = 0,
                  val composer: String = MediaStoreConstants.DEFAULT_COMPOSER,
                  val trackNumber: Int = MediaStoreConstants.DEFAULT_TRACK_NUMBER,
                  val year: Int = MediaStoreConstants.DEFAULT_YEAR) : MSAudioFile(filePath, size, displayName, title, dateAdded)