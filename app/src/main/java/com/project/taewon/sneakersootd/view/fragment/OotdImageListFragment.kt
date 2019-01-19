package com.project.taewon.sneakersootd.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import androidx.recyclerview.widget.GridLayoutManager
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.adapter.SneakersImageListAdapter
import com.project.taewon.sneakersootd.databinding.FragmentOotdImageListBinding
import com.project.taewon.sneakersootd.di.Injectable
import com.project.taewon.sneakersootd.network.ds.ImagePositionalDataSource
import com.project.taewon.sneakersootd.network.model.Image
import com.project.taewon.sneakersootd.view.viewmodel.OotdImageViewModel
import javax.inject.Inject

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

        arguments?.let {
            val query = getQuery(
                it.get(Constants.BUNDLE_NAME) as String,
                it.get(Constants.BUNDLE_BRAND_NAME) as String)
            getSearchImageApi(query, adapter)
        }
    }

    private fun getQuery(name: String, brandName: String): String {
        return "$brandName $name ${Constants.OOTD_KEY}"
    }

    private fun getSearchImageApi(query: String, adapter: SneakersImageListAdapter) {
        // Paging Setup
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(20)
            .setPageSize(10)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(true)
            .build()

        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(OotdImageViewModel::class.java)

        val builder = RxPagedListBuilder<Int, Image>(object: DataSource.Factory<Int, Image>() {
            override fun create(): DataSource<Int, Image> {
                return ImagePositionalDataSource(viewModel, query)
            }
        }, config)

        binding.nameList.adapter = adapter
        builder.buildObservable()
            .subscribe {
                adapter.submitList(it)
            }


//        binding.isError = false
//        networkModel.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, 1).observe(this, Observer { response ->
//            when (response?.status) {
//                Status.SUCCESS -> {
//                    if (!response.data?.items.isNullOrEmpty()) {
//                        val images = response.data?.items
//                        adapter.submitList(images)
//                    }
//                }
//                Status.ERROR -> {
//                    binding.isError = true
//                }
//                Status.LOADING -> {}
//            }
//        })
    }
}
