package com.project.taewon.sneakersootd.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SneakersNameItem(val name: String, val brandName: String, val imageUrl: String) : Parcelable