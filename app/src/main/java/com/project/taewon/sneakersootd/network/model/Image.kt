package com.project.taewon.sneakersootd.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    var kind: String?,
    var title: String?,
    var htmlTitle: String?,
    var link: String?,
    var displayLink: String?,
    var snippet: String?,
    var htmlSnippet: String?,
    var mime: String?,
    var image: ImageInfo?
) : Parcelable