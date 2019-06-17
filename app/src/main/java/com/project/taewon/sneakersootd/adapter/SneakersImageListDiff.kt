package com.project.taewon.sneakersootd.adapter

import androidx.recyclerview.widget.DiffUtil
import com.project.taewon.sneakersootd.db.tables.ImageItem

class SneakersImageListDiff : DiffUtil.ItemCallback<ImageItem>() {
    override fun areItemsTheSame(
        oldItem: ImageItem,
        newItem: ImageItem
    ): Boolean {
        return oldItem.title == newItem.title // check uniqueness
    }

    override fun areContentsTheSame(
        oldItem: ImageItem,
        newItem: ImageItem
    ): Boolean {
        return oldItem == newItem  // check contents
    }
}