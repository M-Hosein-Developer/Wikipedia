package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.Fragment.ExploreFragment
import com.example.Fragment.PhotoGrapherFragment
import com.example.Fragment.ProfileFragment
import com.example.Fragment.TrendFragment
import com.example.wikipedia.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupToolbar()
        setupNavigationDrawer()
        setupBottomNavigation()
        firstRun()

    }

    private fun setupBottomNavigation() {

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_explore -> {
                     replaceFragment(ExploreFragment())
                    binding.navigationViewMAin.menu.getItem(1).isChecked = false
                }

                R.id.menu_trend -> {
                    replaceFragment(TrendFragment())
                    binding.navigationViewMAin.menu.getItem(1).isChecked = false
                }

                R.id.menu_profile -> {
                    replaceFragment(ProfileFragment())
                    binding.navigationViewMAin.menu.getItem(1).isChecked = false
                }

            }

            true
        }

        binding.bottomNavigation.setOnItemReselectedListener {}
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container , fragment)
        transaction.commit()
    }

    private fun setupNavigationDrawer() {
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this ,
            binding.drawerLayoutMain ,
            binding.toolBarMain ,
            R.string.openDrawer ,
            R.string.closeDrawer
        )

       binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()

        binding.navigationViewMAin.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.menu_videoMaker -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_photographer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container , PhotoGrapherFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()

                    binding.navigationViewMAin.menu.getItem(1).isCheckable = true
                    binding.navigationViewMAin.menu.getItem(1).isChecked = true
                }

                R.id.menu_writer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_translator -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_open_wikimedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://www.wikipedia.org/")
                }

                R.id.menu_open_wikipedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://www.wikimedia.org/")
                }

            }

            true
        }

    }

    private fun openWebsite(url: String) {

        val intent = Intent(Intent.ACTION_VIEW , Uri.parse(url))
        startActivity(intent)

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolBarMain)
    }

    private fun firstRun(){
        replaceFragment(ExploreFragment())
        binding.bottomNavigation.selectedItemId = R.id.menu_explore
    }

    override fun onBackPressed() {
        super.onBackPressed()

        binding.navigationViewMAin.menu.getItem(1).isChecked = false
    }

    //menu ...

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main , menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.menu_explore -> {
                replaceFragment(ExploreFragment())
                binding.navigationViewMAin.menu.getItem(1).isChecked = false
            }

            R.id.menu_trend -> {
                replaceFragment(TrendFragment())
                binding.navigationViewMAin.menu.getItem(1).isChecked = false
            }

            R.id.menu_profile -> {
                replaceFragment(ProfileFragment())
                binding.navigationViewMAin.menu.getItem(1).isChecked = false
            }

            R.id.menu_exit -> {
                onBackPressed()
            }

        }

        return true
    }
}