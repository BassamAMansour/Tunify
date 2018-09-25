package com.bassamworks.tunify.fragments.musicControl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bassamworks.tunify.R

class MusicControlFragmentExpanded : androidx.fragment.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_music_control_expanded, container, false)
    }
}