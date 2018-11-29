package com.project.taewon.sneakersootd.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.R
import com.project.taewon.sneakersootd.data.SneakersNameItem
import com.project.taewon.sneakersootd.databinding.NameListItemBinding

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
            val bundle: Bundle = bundleOf(
                Constants.BUNDLE_NAME to name,
                Constants.BUNDLE_BRAND_NAME to brandName
            )
            it.findNavController()
                .navigate(R.id.action_fragment_home_category_to_fragment_ootd_image_list, bundle)
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