package com.project.taewon.googlesearch.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.project.taewon.googlesearch.constants.Constants

import com.project.taewon.googlesearch.adapter.PagerAdapter
import com.project.taewon.googlesearch.databinding.FragmentHomeCategoryBinding
import com.project.taewon.googlesearch.di.Injectable
import com.project.taewon.googlesearch.util.instanceOf
import com.project.taewon.googlesearch.viewmodel.HomeCategoryViewModel
import javax.inject.Inject

/**
 * Category page where user can select sneakers model
 *
 */
class HomeCategoryFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentHomeCategoryBinding
    private lateinit var viewModel: HomeCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeCategoryBinding.inflate(inflater, container, false)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeCategoryViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = PagerAdapter(childFragmentManager)
        setObserver(pagerAdapter)
        viewModel.requestTabInfo() //request asset read
    }

    private fun setObserver(pagerAdapter: PagerAdapter) {
        viewModel.tabInfoLiveData.observe(this, Observer {
            if (!it.tabList.isNullOrEmpty()) {
                it.tabList.forEach { item ->
                    pagerAdapter.addFrag(
                        instanceOf<SneakersNameListFragment>(bundleOf(Constants.BUNDLE_NAME_LIST to item.productList)),
                        item.title
                    )
                }

                binding.viewPager.adapter = pagerAdapter
            }
        })
    }
}
