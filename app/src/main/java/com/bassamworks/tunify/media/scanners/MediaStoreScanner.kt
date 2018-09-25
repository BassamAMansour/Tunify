package com.bassamworks.tunify.media.scanners

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore.Audio.*
import com.bassamworks.tunify.constants.MediaStoreConstants
import com.bassamworks.tunify.models.mediaStore.*
import java.security.InvalidParameterException

class MediaStoreScanner(private val context: Context) {

    fun getAllSongs(): Cursor {

        val contentUri = Media.EXTERNAL_CONTENT_URI

        val selection = Media.IS_MUSIC + "!=?"

        val selectionArgs = arrayOf("0")

        return context.contentResolver.query(contentUri, null, selection, selectionArgs, null)
    }

    fun getAllAlbums(): Cursor {
        val contentUri = Albums.EXTERNAL_CONTENT_URI

        return context.contentResolver.query(contentUri, null, null, null, null)
    }

    fun getAllArtists(): Cursor {
        val contentUri = Artists.EXTERNAL_CONTENT_URI

        return context.contentResolver.query(contentUri, null, null, null, null)
    }

    fun getAllGenres(): Cursor {
        val contentUri = Genres.EXTERNAL_CONTENT_URI

        return context.contentResolver.query(contentUri, null, null, null, null)
    }

    fun getAllPlaylists(): Cursor {
        val contentUri = Playlists.EXTERNAL_CONTENT_URI

        return context.contentResolver.query(contentUri, null, null, null, null)
    }

    /*fun getAllFolders(): Cursor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

    companion object {

        fun getSongsFromCursor(cursor: Cursor): List<MSSong> {
            if (cursor.isClosed || cursor.count <= 0) return listOf()

            val mediaStoreList: ArrayList<MSSong> = ArrayList(cursor.count)

            cursor.moveToPosition(-1)

            while (cursor.moveToNext()) {
                mediaStoreList.add(getSongFromCursor(cursor))
            }

            return mediaStoreList
        }

        fun getAlbumsFromCursor(cursor: Cursor): List<MSAlbum> {
            if (cursor.isClosed || cursor.count <= 0) return listOf()

            val mediaStoreList: ArrayList<MSAlbum> = ArrayList(cursor.count)

            cursor.moveToPosition(-1)

            while (cursor.moveToNext()) {
                mediaStoreList.add(getAlbumFromCursor(cursor))
            }

            return mediaStoreList
        }

        fun getArtistsFromCursor(cursor: Cursor): List<MSArtist> {
            if (cursor.isClosed || cursor.count <= 0) return listOf()

            val mediaStoreList: ArrayList<MSArtist> = ArrayList(cursor.count)

            cursor.moveToPosition(-1)

            while (cursor.moveToNext()) {
                mediaStoreList.add(getArtistFromCursor(cursor))
            }

            return mediaStoreList
        }

        fun getGenresFromCursor(cursor: Cursor): List<MSGenre> {
            if (cursor.isClosed || cursor.count <= 0) return listOf()

            val mediaStoreList: ArrayList<MSGenre> = ArrayList(cursor.count)

            cursor.moveToPosition(-1)

            while (cursor.moveToNext()) {
                mediaStoreList.add(getGenreFromCursor(cursor))
            }

            return mediaStoreList
        }

        fun getPlaylistsFromCursor(cursor: Cursor): List<MSPlaylist> {
            if (cursor.isClosed || cursor.count <= 0) return listOf()

            val mediaStoreList: ArrayList<MSPlaylist> = ArrayList(cursor.count)

            cursor.moveToPosition(-1)

            while (cursor.moveToNext()) {
                mediaStoreList.add(getPlaylistFromCursor(cursor))
            }

            return mediaStoreList
        }

        fun getSongFromCursor(cursor: Cursor): MSSong {
            if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

            val id: Long = cursor.getLong(cursor.getColumnIndex(Media._ID))

            val filePath: String = cursor.getString(cursor.getColumnIndex(Media.DATA))
            val size: Long = cursor.getLong(cursor.getColumnIndex(Media.SIZE))
            val displayName: String = cursor.getString(cursor.getColumnIndex(Media.DISPLAY_NAME))
            val title: String = cursor.getString(cursor.getColumnIndex(Media.TITLE))

            val durationIndex = cursor.getColumnIndex(Media.DURATION)
            val duration: Long? = if (durationIndex != INVALID_COLUMN) cursor.getLong(durationIndex) else null

            val albumIndex = cursor.getColumnIndex(Media.ALBUM)
            val album: String? = if (albumIndex != INVALID_COLUMN) cursor.getString(albumIndex) else null

            val albumIdIndex = cursor.getColumnIndex(Media.ALBUM_ID)
            val albumId: Long? = if (albumIdIndex != INVALID_COLUMN) cursor.getLong(albumIdIndex) else null

            val artistIndex = cursor.getColumnIndex(Media.ARTIST)
            val artist: String? = if (artistIndex != INVALID_COLUMN) cursor.getString(artistIndex) else null

            val artistIdIndex = cursor.getColumnIndex(Media.ARTIST_ID)
            val artistId: Long? = if (artistIdIndex != INVALID_COLUMN) cursor.getLong(artistIdIndex) else null

            val lastPlaybackBookmarkIndex = cursor.getColumnIndex(Media.BOOKMARK)
            val lastPlaybackBookmark: Long? = if (lastPlaybackBookmarkIndex != INVALID_COLUMN) cursor.getLong(lastPlaybackBookmarkIndex) else null

            val composerIndex = cursor.getColumnIndex(Media.COMPOSER)
            val composer: String? = if (composerIndex != INVALID_COLUMN) cursor.getString(composerIndex) else null

            val trackNumberIndex = cursor.getColumnIndex(Media.TRACK)
            val trackNumber: Int? = if (trackNumberIndex != INVALID_COLUMN) cursor.getInt(trackNumberIndex) else null

            val yearIndex = cursor.getColumnIndex(Media.YEAR)
            val year: Int? = if (yearIndex != INVALID_COLUMN) cursor.getInt(yearIndex) else null

            return MSSong(id, filePath, size, displayName, title,
                    duration ?: MediaStoreConstants.DEFAULT_DURATION,
                    album ?: MediaStoreConstants.DEFAULT_ALBUM_NAME,
                    albumId ?: MediaStoreConstants.DEFAULT_ALBUM_ID,
                    artist ?: MediaStoreConstants.DEFAULT_ARTIST_NAME,
                    artistId ?: MediaStoreConstants.DEFAULT_ARTIST_ID,
                    lastPlaybackBookmark ?: MediaStoreConstants.DEFAULT_PLAYBACK_BOOKMARK,
                    composer ?: MediaStoreConstants.DEFAULT_COMPOSER,
                    trackNumber ?: MediaStoreConstants.DEFAULT_TRACK_NUMBER,
                    year ?: MediaStoreConstants.DEFAULT_YEAR)
        }


        fun getAlbumFromCursor(cursor: Cursor): MSAlbum {
            if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

            val id: Long = cursor.getLong(cursor.getColumnIndex(Albums._ID))

            val albumIndex = cursor.getColumnIndex(Albums.ALBUM)
            val album: String? = if (albumIndex != INVALID_COLUMN) cursor.getString(albumIndex) else null

            val albumArtIndex = cursor.getColumnIndex(Albums.ALBUM_ART)
            val albumArt: String? = if (albumArtIndex != INVALID_COLUMN) cursor.getString(albumArtIndex) else null

            val albumIdIndex = cursor.getColumnIndex(Albums.ALBUM_ID)
            val albumId: Long? = if (albumIdIndex != INVALID_COLUMN) cursor.getLong(albumIdIndex) else null

            val artistIndex = cursor.getColumnIndex(Albums.ARTIST)
            val artist: String? = if (artistIndex != INVALID_COLUMN) cursor.getString(artistIndex) else null

            val firstYearIndex = cursor.getColumnIndex(Albums.FIRST_YEAR)
            val firstYear: Int? = if (firstYearIndex != INVALID_COLUMN) cursor.getInt(firstYearIndex) else null

            val lastYearIndex = cursor.getColumnIndex(Albums.LAST_YEAR)
            val lastYear: Int? = if (lastYearIndex != INVALID_COLUMN) cursor.getInt(lastYearIndex) else null

            val numberOfSongsIndex = cursor.getColumnIndex(Albums.NUMBER_OF_SONGS)
            val numberOfSongs: Int? = if (numberOfSongsIndex != INVALID_COLUMN) cursor.getInt(numberOfSongsIndex) else null

            return MSAlbum(id,
                    album ?: MediaStoreConstants.DEFAULT_ALBUM_NAME,
                    albumArt ?: MediaStoreConstants.DEFAULT_ALBUM_ART,
                    albumId ?: MediaStoreConstants.DEFAULT_ALBUM_ID,
                    artist ?: MediaStoreConstants.DEFAULT_ARTIST_NAME,
                    firstYear ?: MediaStoreConstants.DEFAULT_FIRST_YEAR,
                    lastYear ?: MediaStoreConstants.DEFAULT_LAST_YEAR,
                    numberOfSongs ?: MediaStoreConstants.DEFAULT_TRACK_NUMBER)
        }


        fun getArtistFromCursor(cursor: Cursor): MSArtist {
            if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

            val id: Long = cursor.getLong(cursor.getColumnIndex(Artists._ID))

            val artistIndex = cursor.getColumnIndex(Artists.ARTIST)
            val artist: String? = if (artistIndex != INVALID_COLUMN) cursor.getString(artistIndex) else null

            val numberOfAlbumsIndex = cursor.getColumnIndex(Artists.NUMBER_OF_ALBUMS)
            val numberOfAlbums: Int? = if (numberOfAlbumsIndex != INVALID_COLUMN) cursor.getInt(numberOfAlbumsIndex) else null

            val numberOfTracksIndex = cursor.getColumnIndex(Artists.NUMBER_OF_TRACKS)
            val numberOfTracks: Int? = if (numberOfTracksIndex != INVALID_COLUMN) cursor.getInt(numberOfTracksIndex) else null

            return MSArtist(id,
                    artist ?: MediaStoreConstants.DEFAULT_ARTIST_NAME,
                    numberOfAlbums ?: MediaStoreConstants.DEFAULT_NUMBER_OF_ALBUMS,
                    numberOfTracks ?: MediaStoreConstants.DEFAULT_TRACK_NUMBER)
        }


        fun getGenreFromCursor(cursor: Cursor): MSGenre {
            if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

            val id: Long = cursor.getLong(cursor.getColumnIndex(Genres._ID))

            val genreIndex = cursor.getColumnIndex(Genres.NAME)
            val genre: String? = if (genreIndex != INVALID_COLUMN) cursor.getString(genreIndex) else null

            return MSGenre(id,
                    genre ?: MediaStoreConstants.DEFAULT_GENRE)
        }


        fun getPlaylistFromCursor(cursor: Cursor): MSPlaylist {
            if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

            val id: Long = cursor.getLong(cursor.getColumnIndex(Playlists._ID))

            val nameIndex = cursor.getColumnIndex(Playlists.NAME)
            val name: String? = if (nameIndex != INVALID_COLUMN) cursor.getString(nameIndex) else null

            val playlistFilePathIndex = cursor.getColumnIndex(Playlists.DATA)
            val playlistFilePath: String? = if (playlistFilePathIndex != INVALID_COLUMN) cursor.getString(playlistFilePathIndex) else null

            val playlistDateAddedIndex = cursor.getColumnIndex(Playlists.DATE_ADDED)
            val playlistDateAdded: Long? = if (playlistDateAddedIndex != INVALID_COLUMN) cursor.getLong(playlistDateAddedIndex) else null

            val playlistDateModifiedIndex = cursor.getColumnIndex(Playlists.DATE_MODIFIED)
            val playlistDateModified: Long? = if (playlistDateModifiedIndex != INVALID_COLUMN) cursor.getLong(playlistDateModifiedIndex) else null

            return MSPlaylist(id,
                    name ?: MediaStoreConstants.DEFAULT_ARTIST_NAME,
                    playlistFilePath ?: MediaStoreConstants.DEFAULT_PLAYLIST_PATH,
                    playlistDateAdded ?: MediaStoreConstants.DEFAULT_PLAYLIST_DATE_ADDED,
                    playlistDateModified ?: MediaStoreConstants.DEFAULT_PLAYLIST_DATE_MODIFIED)
        }

        private const val INVALID_COLUMN = -1
    }

    private val projectionSongs = arrayOf(Media._ID,
            Media.DATA,
            Media.SIZE,
            Media.DISPLAY_NAME,
            Media.TITLE,
            Media.ALBUM,
            Media.ALBUM_ID,
            Media.ARTIST,
            Media.ARTIST_ID,
            Media.BOOKMARK,
            Media.COMPOSER,
            Media.DURATION,
            Media.TRACK,
            Media.YEAR)

    private val projectionAlbums = arrayOf(Albums._ID,
            Albums.ALBUM,
            Albums.ALBUM_ART,
            Albums.ALBUM_ID,
            Albums.ARTIST,
            Albums.FIRST_YEAR,
            Albums.LAST_YEAR,
            Albums.NUMBER_OF_SONGS)

    private val projectionArtists = arrayOf(Artists._ID,
            Artists.ARTIST,
            Artists.NUMBER_OF_ALBUMS,
            Artists.NUMBER_OF_TRACKS)

    private val projectionGenres = arrayOf(Genres._ID, Genres.NAME)

    private val projectionPlaylists = arrayOf(Playlists._ID,
            Playlists.NAME,
            Playlists.DATA,
            Playlists.DATE_ADDED,
            Playlists.DATE_MODIFIED)
}
