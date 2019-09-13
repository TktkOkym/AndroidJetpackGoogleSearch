package com.project.taewon.googlesearch.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.taewon.googlesearch.constants.Constants

import com.project.taewon.googlesearch.databinding.FragmentImageDetailBinding
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.core.app.ShareCompat
import com.project.taewon.googlesearch.R
import com.project.taewon.googlesearch.db.tables.ImageItem

/**
 * Image Detail page with original link page button and share button
 *
 */
class ImageDetailFragment : Fragment() {

    lateinit var binding: FragmentImageDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.inflate(
        binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.run {
            val image = get(Constants.BUNDLE_IMAGE) as ImageItem?
            binding.apply {
                data = image
                image?.url?.also { url ->
                    if (url.isNotBlank()) {
                        linkButton.setOnClickListener { openLinkByChrome(url) }
                        shareButton.setOnClickListener { openShareLink(url) }
                    }
                }
            }
        }
    }

    private fun openShareLink(url: String) {
        ShareCompat.IntentBuilder
            .from(activity)
            .setType("text/plain")
            .setChooserTitle(getString(R.string.share_link))
            .setText(url)
            .startChooser()
    }

    private fun openLinkByChrome(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            setPackage(Constants.CHROME_PACKAGE_SCHEME)
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            intent.setPackage(null) // Try with the default browser when chrome is not installed
            startActivity(intent)
        }
    }
}
