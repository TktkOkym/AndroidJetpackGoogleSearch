package com.project.taewon.sneakersootd.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.taewon.sneakersootd.R
import com.project.taewon.sneakersootd.adapter.ViewedItemListAdapter
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.databinding.FragmentViewedItemBinding
import com.project.taewon.sneakersootd.db.tables.ImageItem
import com.project.taewon.sneakersootd.di.Injectable
import com.project.taewon.sneakersootd.viewmodel.ViewedItemViewModel
import javax.inject.Inject

/**
 * Show list of viewed items
 *
 */
class ViewedItemFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ViewedItemViewModel
    private lateinit var binding: FragmentViewedItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewedItemBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ViewedItemViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameListAdapter = ViewedItemListAdapter(object: ViewedItemListAdapter.ClickCallback {
            override fun onClick(view: View, item: ImageItem) {
                val bundle = bundleOf(Constants.BUNDLE_IMAGE to item)
                view.findNavController()
                    .navigate(R.id.action_fragment_viewed_item_to_fragment_image_detail, bundle)
            }
        })

        binding.viewedItemList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = nameListAdapter
        }
        subscribeUi(nameListAdapter)
    }

    @Suppress("UNCHECKED_CAST")
    private fun subscribeUi(adapter: ViewedItemListAdapter) {
        viewModel.getViewedItemFromDb().observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
