package com.project.taewon.googlesearch.view.fragment


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.taewon.googlesearch.R
import com.project.taewon.googlesearch.adapter.ViewedItemListAdapter
import com.project.taewon.googlesearch.constants.Constants
import com.project.taewon.googlesearch.databinding.FragmentViewedItemBinding
import com.project.taewon.googlesearch.db.tables.ImageItem
import com.project.taewon.googlesearch.di.Injectable
import com.project.taewon.googlesearch.viewmodel.ViewedItemViewModel
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
    private var isListEmpty = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewedItemBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ViewedItemViewModel::class.java)
        setHasOptionsMenu(true)
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
            isListEmpty = it.isEmpty()
            adapter.submitList(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.viewed_list_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_clear_viewed_item -> removeAll()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun removeAll() {
        if (isListEmpty) {
            Toast.makeText(context, R.string.empty_list, Toast.LENGTH_LONG).show()
        } else {
            val builder = AlertDialog.Builder(context!!)
            with(builder) {
                setTitle(getString(R.string.delete_all))
                setPositiveButton(android.R.string.yes) { _, _ -> viewModel.deleteAllFromDb() }
                setNegativeButton(android.R.string.no) { _, _ -> }
            }.also { it.show() }
        }
    }
}
