package com.project.taewon.sneakersootd.adapter

import androidx.recyclerview.widget.DiffUtil
import com.project.taewon.sneakersootd.data.SneakersNameItem

class SneakersNameListDiff : DiffUtil.ItemCallback<SneakersNameItem>() {
    override fun areItemsTheSame(
        oldItem: SneakersNameItem,
        newItem: SneakersNameItem
    ): Boolean {
        return oldItem.name == newItem.name // check uniqueness
    }

    override fun areContentsTheSame(
        oldItem: SneakersNameItem,
        newItem: SneakersNameItem
    ): Boolean {
        return oldItem == newItem // check contents
    }
}