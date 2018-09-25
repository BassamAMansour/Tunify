package com.bassamworks.tunify.viewModels.library

import android.app.Application
import android.database.Cursor
import com.bassamworks.tunify.excutors.AppExecutors
import com.bassamworks.tunify.media.scanners.MediaStoreScanner
import com.bassamworks.tunify.models.mediaStore.MSSong
import com.bassamworks.tunify.models.ui.Song

class SongsViewModel(application: Application) : LibraryViewModel<MSSong, Song>(application) {
    override fun fetchData() {
        AppExecutors.instance?.diskIO()
                ?.execute {
                    setDataFetched(MediaStoreScanner(getApplication()).getAllSongs())
                }
    }

    override fun getMediaStoreDataFromCursor(cursor: Cursor): List<MSSong> {
        return MediaStoreScanner.getSongsFromCursor(cursor)
    }

    override fun getUIDataFromMediaStoreData(msDataList: List<MSSong>): List<Song> {
        return msDataList.map { it.toUIModel() }
    }
}