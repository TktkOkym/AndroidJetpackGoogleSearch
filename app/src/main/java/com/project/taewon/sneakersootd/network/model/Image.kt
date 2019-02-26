package com.project.taewon.sneakersootd.network.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "sneakers_item")
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