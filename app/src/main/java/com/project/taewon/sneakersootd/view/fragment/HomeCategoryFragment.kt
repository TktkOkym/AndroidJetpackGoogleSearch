package com.project.taewon.sneakersootd.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.R

import com.project.taewon.sneakersootd.adapter.PagerAdapter
import com.project.taewon.sneakersootd.model.SneakersNameItem
import com.project.taewon.sneakersootd.databinding.FragmentHomeCategoryBinding
import com.project.taewon.sneakersootd.util.instanceOf

/**
 * Category page where user can select sneakers model
 *
 */
class HomeCategoryFragment : Fragment() {

    private lateinit var binding: FragmentHomeCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDataBinding()
    }

    private fun initDataBinding() {
        val adapter = PagerAdapter(childFragmentManager)
        setTabLayoutViewData(adapter)
        binding.apply {
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(binding.viewPager)
        }
    }

    // NOTE: Can be handled by server response in the future using proper list of sneakers data
    private fun setTabLayoutViewData(adapter: PagerAdapter) {
        adapter.addFrag(instanceOf<SneakersNameListFragment>(
            bundleOf(Constants.BUNDLE_NAME_LIST to getNikeNameList())),
            getString(R.string.tab_nike))

        adapter.addFrag(instanceOf<SneakersNameListFragment>(
            bundleOf(Constants.BUNDLE_NAME_LIST to getVansList())),
            getString(R.string.tab_vans))

        adapter.addFrag(instanceOf<SneakersNameListFragment>(
            bundleOf(Constants.BUNDLE_NAME_LIST to getNewBalanceList())),
            getString(R.string.tab_new_balance))
    }

    private fun getNikeNameList(): ArrayList<SneakersNameItem> {
        return arrayListOf(
            SneakersNameItem(
                "Airmax 90",
                "Nike",
                "https://img.abc-mart.net/img/goods/7/56499100012.jpg"
            ),
            SneakersNameItem(
                "Airmax 95",
                "Nike",
                "https://img.abc-mart.net/img/goods/7/54972600282.jpg"
            ),
            SneakersNameItem(
                "Airmax 97",
                "Nike",
                "https://img.abc-mart.net/img/goods/7/57080400122.jpg"
            ),
            SneakersNameItem(
                "Airforce 1",
                "Nike",
                "https://img.abc-mart.net/img/goods/7/43506900015.jpg"
            ),
            SneakersNameItem(
                "Vapor Max",
                "Nike",
                "https://img.abc-mart.net/img/goods/7/57855300132.jpg"
            ),
            SneakersNameItem(
                "Huarache",
                "Nike",
                "https://img.abc-mart.net/img/goods/7/52648600292.jpg"
            )
        )
    }

    private fun getVansList(): ArrayList<SneakersNameItem> {
        return arrayListOf(
            SneakersNameItem(
                "OLD SKOOL",
                "Vans",
                "https://img.abc-mart.net/img/goods/7/58347100012.jpg"
            ),
            SneakersNameItem(
                "AUTHENTIC",
                "Vans",
                "https://img.abc-mart.net/img/goods/7/57882700012.jpg"
            ), //
            SneakersNameItem(
                "SK-8",
                "Vans",
                "https://img.abc-mart.net/img/goods/7/56278300042.jpg"
            ),
            SneakersNameItem(
                "Classic Slip-On",
                "Vans",
                "https://img.abc-mart.net/img/goods/7/58180300012.jpg"
            ) //
        )
    }

    private fun getNewBalanceList(): ArrayList<SneakersNameItem> {
        return arrayListOf(
            SneakersNameItem(
                "M1400",
                "New Balance",
                "https://img.abc-mart.net/img/goods/7/00381300792.jpg"
            ),
            SneakersNameItem(
                "M1500",
                "New Balance",
                "https://img.abc-mart.net/img/goods/7/47691000022.jpg"
            ),
            SneakersNameItem(
                "M996",
                "New Balance",
                "https://img.abc-mart.net/img/goods/7/54297900015.jpg"
            )
        )
    }
}
