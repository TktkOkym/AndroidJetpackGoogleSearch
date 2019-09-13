package com.project.taewon.googlesearch.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.project.taewon.googlesearch.R
import com.project.taewon.googlesearch.databinding.ActivityHomeBinding
import com.project.taewon.googlesearch.view.fragment.HomeCategoryFragmentDirections
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HasSupportFragmentInjector {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)
        drawerLayout = binding.drawerLayout

        navController = Navigation.findNavController(this, R.id.home_navigation_fragment)

        // Set up ActionBar
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        with(binding.navigationView) {
            setupWithNavController(navController)
            setNavigationItemSelectedListener(NavigationListener())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.home_navigation_fragment),
            drawerLayout)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    internal inner class NavigationListener : NavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.nav_viewed_items -> openViewedItem()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            return false
        }
    }

    private fun openViewedItem() {
        navController.navigate(HomeCategoryFragmentDirections.actionFragmentHomeCategoryToFragmentViewedItem())
    }
}
