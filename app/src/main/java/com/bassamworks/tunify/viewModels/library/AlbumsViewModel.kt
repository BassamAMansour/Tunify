package com.bassamworks.tunify.viewModels.library

import android.app.Application
import android.database.Cursor
import com.bassamworks.tunify.excutors.AppExecutors
import com.bassamworks.tunify.media.scanners.MediaStoreScanner
import com.bassamworks.tunify.models.mediaStore.MSAlbum
import com.bassamworks.tunify.models.ui.Album

class AlbumsViewModel(application: Application) : LibraryViewModel<MSAlbum, Album>(application) {
    override fun fetchData() {
        AppExecutors.instance?.diskIO()
                ?.execute {
                    setDataFetched(MediaStoreScanner(getApplication()).getAllAlbums())
                }
    }

    override fun getMediaStoreDataFromCursor(cursor: Cursor): List<MSAlbum> {
        return MediaStoreScanner.getAlbumsFromCursor(cursor)
    }

    override fun getUIDataFromMediaStoreData(msDataList: List<MSAlbum>): List<Album> {
        return msDataList.map { it.toUIModel() }
    }
}