package com.project.taewon.sneakersootd.util

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Pass arguments to a Fragment without the hassle of
 * creating a static newInstance() method for every Fragment.
 *
 * Declared outside any class to have full access in any
 * part of your package.
 *
 * Usage: instanceOf<MyFragment>("foo" to true, "bar" to 0)
 *
 * @return Returns an instance of Fragment as the specified generic type with the params applied as arguments
 */
inline fun <reified T : Fragment> instanceOf(bundle: Bundle?): T = T::class.java.newInstance().apply {
    arguments = bundle
}