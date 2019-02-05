package com.project.taewon.sneakersootd.adapter

import androidx.recyclerview.widget.DiffUtil
import com.project.taewon.sneakersootd.network.model.Image

class SneakersImageListDiff : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(
        oldItem: Image,
        newItem: Image
    ): Boolean {
        return oldItem.title == newItem.title // check uniqueness
    }

    override fun areContentsTheSame(
        oldItem: Image,
        newItem: Image
    ): Boolean {
        return oldItem == newItem  // check contents
    }
}