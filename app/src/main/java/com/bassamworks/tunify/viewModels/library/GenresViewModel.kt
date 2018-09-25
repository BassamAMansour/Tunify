package com.bassamworks.tunify.viewModels.library

import android.app.Application
import android.database.Cursor
import com.bassamworks.tunify.excutors.AppExecutors
import com.bassamworks.tunify.media.scanners.MediaStoreScanner
import com.bassamworks.tunify.models.mediaStore.MSGenre
import com.bassamworks.tunify.models.ui.Genre

class GenresViewModel(application: Application) : LibraryViewModel<MSGenre, Genre>(application) {
    override fun fetchData() {
        AppExecutors.instance?.diskIO()
                ?.execute {
                    setDataFetched(MediaStoreScanner(getApplication()).getAllGenres())
                }
    }

    override fun getMediaStoreDataFromCursor(cursor: Cursor): List<MSGenre> {
        return MediaStoreScanner.getGenresFromCursor(cursor)
    }

    override fun getUIDataFromMediaStoreData(msDataList: List<MSGenre>): List<Genre> {
        return msDataList.map { it.toUIModel() }
    }
}