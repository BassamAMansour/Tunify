package com.bassamworks.tunify.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import com.bassamworks.tunify.R
import com.bassamworks.tunify.extentions.hasPermission
import com.bassamworks.tunify.fragments.FoldersFragment
import com.bassamworks.tunify.fragments.HomeFragment
import com.bassamworks.tunify.fragments.LibraryFragment
import com.bassamworks.tunify.fragments.PlayQueueFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar_main_activity)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar_main_activity, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        checkPermissions()

        savedInstanceState ?: replaceFragment(HomeFragment())

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            //TODO: add search action
            R.id.action_search -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(HomeFragment())
            }
            R.id.nav_play_queue -> {
                replaceFragment(PlayQueueFragment())
            }
            R.id.nav_library -> {
                replaceFragment(LibraryFragment())
            }
            R.id.nav_folders -> {
                replaceFragment(FoldersFragment())
            }
            R.id.nav_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
            }
            R.id.nav_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .commit()
    }

    private fun checkPermissions() {
        if (!hasPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), RC_READ_EXTERNAL_STORAGE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {

            RC_READ_EXTERNAL_STORAGE -> {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) finish()//TODO:Show a message that this is required to continue
            }

            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    companion object {
        private const val RC_READ_EXTERNAL_STORAGE: Int = 100
    }
}
