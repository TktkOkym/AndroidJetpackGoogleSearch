package com.project.taewon.googlesearch.db.tables

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "sneakers_item")
data class ImageItem(
    @PrimaryKey
    var title: String,
    var url: String,
    var isLiked: Boolean = false
) : Parcelable
