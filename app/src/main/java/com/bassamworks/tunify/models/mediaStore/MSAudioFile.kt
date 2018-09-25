package com.bassamworks.tunify.models.mediaStore

import com.bassamworks.tunify.models.IModelType

open class MSAudioFile(open val id: Long,
                       open val filePath: String,
                       open val size: Long,
                       open val displayName: String,
                       open val title: String) : IModelType.MediaStore