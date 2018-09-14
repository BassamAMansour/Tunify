package com.bassamworks.tunify.constants

object MediaStoreConstants {

    //MSAlbum
    const val DEFAULT_ALBUM_NAME: String = ""
    const val DEFAULT_ALBUM_ID: Long = -1
    const val DEFAULT_ALBUM_KEY: String = ""
    const val DEFAULT_ALBUM_ART: String = ""
    const val DEFAULT_FIRST_YEAR: Int = -1
    const val DEFAULT_LAST_YEAR: Int = -1
    const val DEFAULT_NUMBER_OF_SONGS: Int = 0
    const val DEFAULT_NUMBER_OF_ALBUMS: Int = 0

    //MSSong
    const val DEFAULT_ARTIST_NAME: String = ""
    const val DEFAULT_ARTIST_ID: Long = -1
    const val DEFAULT_ARTIST_KEY: String = ""
    const val DEFAULT_COMPOSER: String = ""
    const val DEFAULT_TITLE_KEY: String = ""
    const val DEFAULT_TRACK_NUMBER: Int = -1
    const val DEFAULT_YEAR: Int = -1

    //MSGenre
    const val DEFAULT_GENRE: String = ""

    //MSPlaylist
    const val DEFAULT_PLAYLIST_NAME: String = ""
    const val DEFAULT_PLAYLIST_PATH: String = ""
    const val DEFAULT_PLAYLIST_DATE_ADDED: Long = -1
    const val DEFAULT_PLAYLIST_DATE_MODIFIED: Long = -1

    //MSAudioFile
    const val DEFAULT_FILE_PATH: String = ""
    const val DEFAULT_DISPLAY_NAME: String = ""
    const val DEFAULT_TITLE: String = ""
    const val DEFAULT_DATE_ADDED: Long = -1
}

object NearbyConstants {

    val nearbyPermessions = arrayOf("android.permission.BLUETOOTH",
            "android.permission.BLUETOOTH_ADMIN",
            "android.permission.ACCESS_WIFI_STATE",
            "android.permission.CHANGE_WIFI_STATE",
            "android.permission.ACCESS_COARSE_LOCATION")
}