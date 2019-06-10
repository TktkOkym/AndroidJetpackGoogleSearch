package com.project.taewon.sneakersootd.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.taewon.sneakersootd.data.SneakersNameItem
import com.project.taewon.sneakersootd.databinding.NameListItemBinding
import com.project.taewon.sneakersootd.view.fragment.HomeCategoryFragmentDirections

class SneakersNameListAdapter : ListAdapter<SneakersNameItem,
        SneakersNameListAdapter.ViewHolder>(SneakersNameListDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NameListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(createOnClickListener(item.name, item.brandName), item)
            itemView.tag = item
        }
    }

    private fun createOnClickListener(name: String, brandName: String): View.OnClickListener {
        return View.OnClickListener {
            val direction
                    = HomeCategoryFragmentDirections.actionFragmentHomeCategoryToFragmentOotdImageList(name, brandName)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: NameListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: SneakersNameItem) {
            binding.apply {
                clickListener = listener
                data = item
                executePendingBindings()
            }
        }
    }
}