package com.bassamworks.tunify.models.mediaStore

open class MSAudioFile(open val filePath: String,
                       open val size: Long,
                       open val displayName: String,
                       open val title: String,
                       open val dateAdded: Long)