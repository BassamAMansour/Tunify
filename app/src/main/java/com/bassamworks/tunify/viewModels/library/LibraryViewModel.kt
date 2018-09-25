package com.bassamworks.tunify.viewModels.library

import android.app.Application
import android.database.ContentObserver
import android.database.Cursor
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bassamworks.tunify.models.IModelType

abstract class LibraryViewModel<MediaStoreModel : IModelType.MediaStore, UIModel : IModelType.UI>(application: Application)
    : AndroidViewModel(application) {

    private val liveData: MutableLiveData<List<UIModel>> = MutableLiveData()
    private var mediaStoreDataList: List<MediaStoreModel> = listOf()

    private lateinit var cursor: Cursor

    init {
        this.fetchData()
    }

    protected abstract fun fetchData()

    protected abstract fun getMediaStoreDataFromCursor(cursor: Cursor): List<MediaStoreModel>

    protected abstract fun getUIDataFromMediaStoreData(msDataList: List<MediaStoreModel>): List<UIModel>

    protected fun setDataFetched(cursor: Cursor) {
        this.cursor = cursor
        updateDataForObservers(cursor)
        setCursorContentObserver()
    }

    private fun updateDataForObservers(cursor: Cursor) {
        mediaStoreDataList = getMediaStoreDataFromCursor(cursor)
        setLiveData(getUIDataFromMediaStoreData(mediaStoreDataList))
    }

    private fun setLiveData(data: List<UIModel>) {
        this.liveData.postValue(data)
    }

    fun getLiveData(): LiveData<List<UIModel>> {
        return liveData
    }

    private val contentObserver: ContentObserver = object : ContentObserver(null) {

        override fun onChange(selfChange: Boolean, uri: Uri?) {
            //TODO:Check if the cursor automatically contains the new data
            updateDataForObservers(cursor)
        }

        override fun onChange(selfChange: Boolean) {
            onChange(selfChange, null)
        }
    }

    private fun setCursorContentObserver() {
        cursor.registerContentObserver(contentObserver)
    }


    override fun onCleared() {
        super.onCleared()
        cursor.unregisterContentObserver(contentObserver)
    }
}