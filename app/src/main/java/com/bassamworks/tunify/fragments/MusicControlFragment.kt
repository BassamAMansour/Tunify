package com.bassamworks.tunify.fragments

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetBehavior.STATE_COLLAPSED
import android.support.design.widget.BottomSheetBehavior.STATE_EXPANDED
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bassamworks.tunify.R
import kotlinx.android.synthetic.main.fragment_music_control.*

class MusicControlFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music_control, container, false)
    }

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)
        setupBottomSheetBehaviour(view)
    }

    private fun setupBottomSheetBehaviour(view: View?) {
        val sheetBehaviour = BottomSheetBehavior.from(view)
        sheetBehaviour.peekHeight = includer_music_control_collapsed.height
        sheetBehaviour.setBottomSheetCallback(MusicControlBottomSheetCallbacks())

        val layoutParams = view?.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = sheetBehaviour
        view.layoutParams = layoutParams
    }

    private inner class MusicControlBottomSheetCallbacks : BottomSheetBehavior.BottomSheetCallback() {
        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            includer_music_control_collapsed.alpha = 1 - slideOffset
            includer_music_control_expanded.alpha = slideOffset
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                STATE_COLLAPSED -> {
                    includer_music_control_expanded.visibility = View.GONE
                    includer_music_control_collapsed.visibility = View.VISIBLE
                }
                STATE_EXPANDED -> {
                    includer_music_control_expanded.visibility = View.VISIBLE
                    includer_music_control_collapsed.visibility = View.GONE
                }
            }
        }
    }
}

