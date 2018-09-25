package com.bassamworks.tunify.viewModels.library

import android.app.Application
import android.database.Cursor
import com.bassamworks.tunify.excutors.AppExecutors
import com.bassamworks.tunify.media.scanners.MediaStoreScanner
import com.bassamworks.tunify.models.mediaStore.MSArtist
import com.bassamworks.tunify.models.ui.Artist

class ArtistsViewModel(application: Application) : LibraryViewModel<MSArtist, Artist>(application) {
    override fun fetchData() {
        AppExecutors.instance?.diskIO()
                ?.execute {
                    setDataFetched(MediaStoreScanner(getApplication()).getAllArtists())
                }
    }

    override fun getMediaStoreDataFromCursor(cursor: Cursor): List<MSArtist> {
        return MediaStoreScanner.getArtistsFromCursor(cursor)
    }

    override fun getUIDataFromMediaStoreData(msDataList: List<MSArtist>): List<Artist> {
        return msDataList.map { it.toUIModel() }
    }
}