package com.bassamworks.tunify.fragments


import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bassamworks.tunify.R
import com.bassamworks.tunify.adapters.cursorAdapters.FoldersCursorAdapter
import com.bassamworks.tunify.excutors.AppExecutors
import kotlinx.android.synthetic.main.fragment_folders.*

class FoldersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_folders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllFolders(view.context)
    }

    private fun getAllFolders(context: Context) {
        AppExecutors.instance?.diskIO()?.execute {
            //TODO:Implement getAllFolders
            //updateAdapter(context,  MediaStoreScanner(context).getAllFolders())
        }
    }

    private fun updateAdapter(context: Context, cursor: Cursor) {
        lv_songs_folders.adapter = FoldersCursorAdapter(context, cursor)
    }

}
