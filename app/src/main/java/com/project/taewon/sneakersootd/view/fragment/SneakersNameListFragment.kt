package com.project.taewon.sneakersootd.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.project.taewon.sneakersootd.constants.Constants
import com.project.taewon.sneakersootd.adapter.SneakersNameListAdapter
import com.project.taewon.sneakersootd.data.SneakersNameItem
import com.project.taewon.sneakersootd.databinding.FragmentSneakersNameListBinding

/**
 * Sneakers Name List Fragment
 *
 */
class SneakersNameListFragment : Fragment() {

    private lateinit var binding: FragmentSneakersNameListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSneakersNameListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val nameListAdapter = SneakersNameListAdapter()
        binding.nameList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = nameListAdapter
        }
        subscribeUi(nameListAdapter)
    }

    @Suppress("UNCHECKED_CAST")
    private fun subscribeUi(adapter: SneakersNameListAdapter) {
        arguments?.run {
            val itemList = get(Constants.BUNDLE_NAME_LIST) as ArrayList<SneakersNameItem>
            adapter.submitList(itemList)
        }
    }
}
