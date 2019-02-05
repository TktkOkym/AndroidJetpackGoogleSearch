package com.project.taewon.sneakersootd.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.adapter.SneakersImageListAdapter
import com.project.taewon.sneakersootd.databinding.FragmentOotdImageListBinding
import com.project.taewon.sneakersootd.di.Injectable
import com.project.taewon.sneakersootd.view.viewmodel.OotdImageViewModel
import javax.inject.Inject
import androidx.paging.LivePagedListBuilder
import androidx.lifecycle.Observer
import com.project.taewon.sneakersootd.factory.ImageListDataFactory
import java.util.concurrent.Executors

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
        // Paging Setup using LiveData / Factory
        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(OotdImageViewModel::class.java)

        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(20)
            .setPageSize(10)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(true)
            .build()

        val pagedItems = LivePagedListBuilder(ImageListDataFactory(viewModel, query), config)
            .setFetchExecutor(Executors.newFixedThreadPool(5))
            .build()

        pagedItems.observe(this, Observer { pagedItems ->
            adapter.submitList(pagedItems)
        })


        /*
         * Using RxPagedListBuilder
         */
//        val dataSource = ImagePositionalDataSource(viewModel, query)
//        val builder = RxPagedListBuilder<Int, Image>(object: DataSource.Factory<Int, Image>() {
//            override fun create(): DataSource<Int, Image> {
//                return ImagePositionalDataSource(viewModel, query)
//            }
//        }, config)
//        binding.nameList.adapter = adapter
//        builder.buildObservable()
//            .subscribe {
//                adapter.submitList(it)
//            }
    }
}
