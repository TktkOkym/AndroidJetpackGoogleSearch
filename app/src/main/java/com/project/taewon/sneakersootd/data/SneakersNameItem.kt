package com.project.taewon.sneakersootd.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SneakersNameItem(val name: String, val brandName: String, val imageUrl: String) : Parcelable