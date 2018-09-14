package com.bassamworks.tunify.media.scanners

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.provider.MediaStore.Audio.*
import android.provider.MediaStore.MediaColumns
import com.bassamworks.tunify.models.mediaStore.*
import java.security.InvalidParameterException

class MediaStoreScanner(private val context: Context) {

    fun getAllSongs(): Cursor {

        val contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val selection = AudioColumns.IS_MUSIC + "!=?"

        val selectionArgs = arrayOf("0")

        return context.contentResolver.query(contentUri, projectionSongs, selection, selectionArgs, null)
    }

    fun getAllAlbums(): Cursor {
        val contentUri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI

        return context.contentResolver.query(contentUri, projectionAlbums, null, null, null)
    }

    fun getAllArtists(): Cursor {
        val contentUri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI

        return context.contentResolver.query(contentUri, projectionArtists, null, null, null)
    }

    fun getAllGenres(): Cursor {
        val contentUri = MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI

        return context.contentResolver.query(contentUri, projectionGenres, null, null, null)
    }

    fun getAllPlaylists(): Cursor {
        val contentUri = MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI

        return context.contentResolver.query(contentUri, projectionPlaylists, null, null, null)
    }

    /*fun getAllFolders(): Cursor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

    private val projectionSongs = arrayOf(MediaColumns.DATA,
            MediaColumns.SIZE,
            MediaColumns.DISPLAY_NAME,
            MediaColumns.TITLE,
            MediaColumns.DATE_ADDED,
            AudioColumns.ALBUM,
            AudioColumns.ALBUM_ID,
            AudioColumns.ARTIST,
            AudioColumns.ARTIST_ID,
            AudioColumns.BOOKMARK,
            AudioColumns.COMPOSER,
            AudioColumns.DURATION,
            AudioColumns.TRACK,
            AudioColumns.YEAR)

    private val projectionAlbums = arrayOf(AlbumColumns.ALBUM,
            AlbumColumns.ALBUM_ART,
            AlbumColumns.ALBUM_ID,
            AlbumColumns.ARTIST,
            AlbumColumns.FIRST_YEAR,
            AlbumColumns.LAST_YEAR,
            AlbumColumns.NUMBER_OF_SONGS)

    private val projectionArtists = arrayOf(ArtistColumns.ARTIST,
            ArtistColumns.NUMBER_OF_ALBUMS,
            ArtistColumns.NUMBER_OF_TRACKS)

    private val projectionGenres = arrayOf(GenresColumns.NAME)

    private val projectionPlaylists = arrayOf(PlaylistsColumns.NAME,
            PlaylistsColumns.DATA,
            PlaylistsColumns.DATE_ADDED,
            PlaylistsColumns.DATE_MODIFIED)
}

fun getSongFromCursor(cursor: Cursor): MSSong {
    if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

    val filePath: String = cursor.getString(cursor.getColumnIndex(MediaColumns.DATA))
    val size: Long = cursor.getLong(cursor.getColumnIndex(MediaColumns.SIZE))
    val displayName: String = cursor.getString(cursor.getColumnIndex(MediaColumns.DISPLAY_NAME))
    val title: String = cursor.getString(cursor.getColumnIndex(MediaColumns.TITLE))
    val dateAdded: Long = cursor.getLong(cursor.getColumnIndex(MediaColumns.DATE_ADDED))

    val duration: Long = cursor.getLong(cursor.getColumnIndex(AudioColumns.DURATION))
    val album: String = cursor.getString(cursor.getColumnIndex(AudioColumns.ALBUM))
    val albumId: Long = cursor.getLong(cursor.getColumnIndex(AudioColumns.ALBUM_ID))
    val artist: String = cursor.getString(cursor.getColumnIndex(AudioColumns.ARTIST))
    val artistId: Long = cursor.getLong(cursor.getColumnIndex(AudioColumns.ARTIST_ID))
    val lastPlaybackBookmark: Long = cursor.getLong(cursor.getColumnIndex(AudioColumns.BOOKMARK))
    val composer: String = cursor.getString(cursor.getColumnIndex(AudioColumns.COMPOSER))
    val trackNumber: Int = cursor.getInt(cursor.getColumnIndex(AudioColumns.TRACK))
    val year: Int = cursor.getInt(cursor.getColumnIndex(AudioColumns.YEAR))

    return MSSong(filePath, size, displayName, title, dateAdded, duration, album, albumId,
            artist, artistId, lastPlaybackBookmark, composer, trackNumber, year)
}

fun getAlbumFromCursor(cursor: Cursor): MSAlbum {
    if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

    val album: String = cursor.getString(cursor.getColumnIndex(AlbumColumns.ALBUM))
    val albumArt: String = cursor.getString(cursor.getColumnIndex(AlbumColumns.ALBUM_ART))
    val albumId: Long = cursor.getLong(cursor.getColumnIndex(AlbumColumns.ALBUM_ID))
    val artist: String = cursor.getString(cursor.getColumnIndex(AlbumColumns.ARTIST))
    val firstYear: Int = cursor.getInt(cursor.getColumnIndex(AlbumColumns.FIRST_YEAR))
    val lastYear: Int = cursor.getInt(cursor.getColumnIndex(AlbumColumns.LAST_YEAR))
    val numberOfSongs: Int = cursor.getInt(cursor.getColumnIndex(AlbumColumns.NUMBER_OF_SONGS))

    return MSAlbum(album, albumArt, albumId, artist, firstYear, lastYear, numberOfSongs)
}

fun getArtistFromCursor(cursor: Cursor): MSArtist {
    if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

    val artist: String = cursor.getString(cursor.getColumnIndex(ArtistColumns.ARTIST))
    val numberOfAlbums: Int = cursor.getInt(cursor.getColumnIndex(ArtistColumns.NUMBER_OF_ALBUMS))
    val numberOfTracks: Int = cursor.getInt(cursor.getColumnIndex(ArtistColumns.NUMBER_OF_TRACKS))

    return MSArtist(artist, numberOfAlbums, numberOfTracks)
}

fun getGenreFromCursor(cursor: Cursor): MSGenre {
    if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

    val genre: String = cursor.getString(cursor.getColumnIndex(GenresColumns.NAME))

    return MSGenre(genre)
}

fun getPlaylistFromCursor(cursor: Cursor): MSPlaylist {
    if (cursor.isClosed || cursor.count == 0) throw InvalidParameterException("Invalid cursor")

    val name: String = cursor.getString(cursor.getColumnIndex(PlaylistsColumns.NAME))
    val playlistFilePath: String = cursor.getString(cursor.getColumnIndex(PlaylistsColumns.DATA))
    val playlistDateAdded: Long = cursor.getLong(cursor.getColumnIndex(PlaylistsColumns.DATE_ADDED))
    val playlistDateModified: Long = cursor.getLong(cursor.getColumnIndex(PlaylistsColumns.DATE_MODIFIED))

    return MSPlaylist(name, playlistFilePath, playlistDateAdded, playlistDateModified)
}