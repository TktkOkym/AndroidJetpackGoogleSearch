package com.project.taewon.sneakersootd.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.taewon.sneakersootd.databinding.ViewedListItemBinding
import com.project.taewon.sneakersootd.db.tables.ImageItem

class ViewedItemListAdapter(val callback: ClickCallback) : ListAdapter<ImageItem,
        ViewedItemListAdapter.ViewHolder>(SneakersImageListDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO: use new item layout with check box for removing items
        return ViewHolder(ViewedListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.also {
            holder.apply {
                bind(createOnClickListener(it), it)
                itemView.tag = it
            }
        }
    }

    private fun createOnClickListener(item: ImageItem): View.OnClickListener {
        return View.OnClickListener {
            callback.onClick(it, item)
        }
    }

    class ViewHolder(
        private val binding: ViewedListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: ImageItem) {
            binding.apply {
                clickListener = listener
                data = item
                executePendingBindings()
            }
        }
    }

    interface ClickCallback {
        fun onClick(view: View, item: ImageItem)
    }
}