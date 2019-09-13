package com.project.taewon.googlesearch.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageInfo(
    var contextLink: String? = null,
    var height: Int? = null,
    var width: Int? = null,
    var byteSize: Int? = null,
    var thumbnailLink: String? = null,
    var thumbnailHeight: Int? = null,
    var thumbnailWidth: Int? = null
) : Parcelable