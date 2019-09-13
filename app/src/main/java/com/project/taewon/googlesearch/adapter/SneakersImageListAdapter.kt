package com.project.taewon.googlesearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.taewon.googlesearch.databinding.ImageListItemBinding
import com.project.taewon.googlesearch.db.tables.ImageItem

class SneakersImageListAdapter(val callback: ClickCallback) : PagedListAdapter<ImageItem,
        SneakersImageListAdapter.ViewHolder>(SneakersImageListDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageListItemBinding.inflate(
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
        private val binding: ImageListItemBinding
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