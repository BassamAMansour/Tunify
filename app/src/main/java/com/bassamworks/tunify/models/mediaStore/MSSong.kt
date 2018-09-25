package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.IModelType
import com.bassamworks.tunify.models.ui.Song

data class MSSong(override val id: Long,
                  override val filePath: String,
                  override val size: Long,
                  override val displayName: String,
                  override val title: String,
                  val duration: Long = MediaStoreConstants.DEFAULT_DURATION,
                  val album: String = MediaStoreConstants.DEFAULT_ALBUM_NAME,
                  val albumId: Long = MediaStoreConstants.DEFAULT_ALBUM_ID,
                  val artist: String = MediaStoreConstants.DEFAULT_ARTIST_NAME,
                  val artistId: Long = MediaStoreConstants.DEFAULT_ARTIST_ID,
                  val lastPlaybackBookmark: Long = MediaStoreConstants.DEFAULT_PLAYBACK_BOOKMARK,
                  val composer: String = MediaStoreConstants.DEFAULT_COMPOSER,
                  val trackNumber: Int = MediaStoreConstants.DEFAULT_TRACK_NUMBER,
                  val year: Int = MediaStoreConstants.DEFAULT_YEAR)
    : MSAudioFile(id, filePath, size, displayName, title), IModelType.MediaStore {

    fun toUIModel() = Song(id, filePath, title, album, artist, duration.toDouble(), lastPlaybackBookmark.toDouble())

}

