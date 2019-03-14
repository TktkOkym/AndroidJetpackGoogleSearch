package com.project.taewon.sneakersootd.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.adapter.SneakersImageListAdapter
import com.project.taewon.sneakersootd.databinding.FragmentOotdImageListBinding
import com.project.taewon.sneakersootd.di.Injectable
import com.project.taewon.sneakersootd.view.viewmodel.OotdImageViewModel
import javax.inject.Inject
import androidx.lifecycle.Observer

/**
 * Sneakers Ootd Image List Fragment
 *
 */
class OotdImageListFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentOotdImageListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOotdImageListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = SneakersImageListAdapter()
        binding.nameList.layoutManager = GridLayoutManager(context, 1)
        binding.nameList.adapter = adapter

        arguments?.run {
            val query = getQuery(
                get(Constants.BUNDLE_NAME) as String,
                get(Constants.BUNDLE_BRAND_NAME) as String)
            getSearchImageApi(query, adapter)
        }
    }

    private fun getQuery(name: String, brandName: String): String {
        return "$brandName $name ${Constants.OOTD_KEY}"
    }

    private fun getSearchImageApi(query: String, adapter: SneakersImageListAdapter) {
        // Paging Setup using LiveData / Factory
        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(OotdImageViewModel::class.java)
        viewModel.setPagedList(query)
        viewModel.pagedItems.observe(this, Observer { pagedItems ->
            adapter.submitList(pagedItems)
        })
    }
}