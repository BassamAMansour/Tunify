package com.bassamworks.tunify.viewModels.library

import android.app.Application
import android.database.Cursor
import com.bassamworks.tunify.excutors.AppExecutors
import com.bassamworks.tunify.media.scanners.MediaStoreScanner
import com.bassamworks.tunify.models.mediaStore.MSPlaylist
import com.bassamworks.tunify.models.ui.Playlist

class PlaylistsViewModel(application: Application) : LibraryViewModel<MSPlaylist, Playlist>(application) {
    override fun fetchData() {
        AppExecutors.instance?.diskIO()
                ?.execute {
                    setDataFetched(MediaStoreScanner(getApplication()).getAllPlaylists())
                }
    }

    override fun getMediaStoreDataFromCursor(cursor: Cursor): List<MSPlaylist> {
        return MediaStoreScanner.getPlaylistsFromCursor(cursor)
    }

    override fun getUIDataFromMediaStoreData(msDataList: List<MSPlaylist>): List<Playlist> {
        return msDataList.map { it.toUIModel() }
    }
}