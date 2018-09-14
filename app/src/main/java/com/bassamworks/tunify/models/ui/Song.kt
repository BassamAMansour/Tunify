package com.bassamworks.tunify.models.ui

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso

data class Song(val id: Long,
                val title: String,
                val album: String,
                val artist: String,
                val length: Double,
                val progress: Double,
                val imgUri: String)

fun Song.getImgUri(): Uri = Uri.parse(imgUri)

@BindingAdapter("app:img")
fun loadImg(iv: ImageView, uri: String) {
    Picasso.get().load(uri).into(iv)
}

