package com.project.taewon.sneakersootd.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.adapter.SneakersImageListAdapter
import com.project.taewon.sneakersootd.databinding.FragmentOotdImageListBinding
import com.project.taewon.sneakersootd.di.Injectable
import com.project.taewon.sneakersootd.viewmodel.OotdImageViewModel
import javax.inject.Inject
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.project.taewon.sneakersootd.R
import com.project.taewon.sneakersootd.db.tables.ImageItem

/**
 * Sneakers Ootd Image List Fragment
 *
 */
class OotdImageListFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentOotdImageListBinding
    private lateinit var viewModel: OotdImageViewModel
    private var pagedItems: List<ImageItem>? = null
    private val args: OotdImageListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOotdImageListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OotdImageViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SneakersImageListAdapter(object: SneakersImageListAdapter.ClickCallback {
            override fun onClick(view: View, item: ImageItem) {
                viewModel.insertItemToDb(item) //insert item to db for 'viewed page'
                val bundle = bundleOf(Constants.BUNDLE_IMAGE to item)
                view.findNavController()
                    .navigate(R.id.action_fragment_ootd_image_list_to_fragment_image_detail, bundle)
            }
        })

        binding.nameList.layoutManager = GridLayoutManager(context, 2)
        binding.nameList.adapter = adapter

        if (pagedItems.isNullOrEmpty()) { //To avoid API call when coming back from next page
            viewModel.setPagedList(getQuery(args.title, args.brandName))
        }

        viewModel.pagedItems.observe(this, Observer { adapter.submitList(it) })
    }

    private fun getQuery(name: String?, brandName: String?): String {
        return "${brandName.orEmpty()} ${name.orEmpty()} ${Constants.OOTD_KEY}"
    }
}