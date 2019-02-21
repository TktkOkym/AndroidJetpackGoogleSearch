package com.project.taewon.sneakersootd.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.R
import com.project.taewon.sneakersootd.databinding.ImageListItemBinding
import com.project.taewon.sneakersootd.network.model.Image

class SneakersImageListAdapter : PagedListAdapter<Image,
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

    private fun createOnClickListener(item: Image): View.OnClickListener {
        return View.OnClickListener {

            val bundle = bundleOf(
                Constants.BUNDLE_IMAGE to item
            )
            it.findNavController()
                .navigate(R.id.action_fragment_ootd_image_list_to_fragment_image_detail, bundle)
        }
    }

    class ViewHolder(
        private val binding: ImageListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Image) {
            binding.apply {
                clickListener = listener
                data = item
                executePendingBindings()
            }
        }
    }
}