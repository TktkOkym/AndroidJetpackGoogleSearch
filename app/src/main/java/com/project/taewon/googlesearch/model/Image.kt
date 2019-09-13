package com.project.taewon.googlesearch.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    @PrimaryKey
    var title: String?,
    var kind: String?,
    var htmlTitle: String?,
    var link: String?,
    var displayLink: String?,
    var snippet: String?,
    var htmlSnippet: String?,
    var mime: String?,
    var image: ImageInfo?
) : Parcelable