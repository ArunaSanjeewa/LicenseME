package com.example.redhunter.licenseme

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                val i = Intent(this@MainActivity, PerDetails::class.java)
                startActivity(i)
            }
            R.id.nav_gallery -> {
                val i = Intent(this@MainActivity, RegistationDetails::class.java)
                startActivity(i)
            }
            R.id.nav_slideshow -> {
                val i = Intent(this@MainActivity, Payment::class.java)
                startActivity(i)
            }
            R.id.nav_manage -> {
                val i = Intent(this@MainActivity, LessonList::class.java)
                startActivity(i)
            }
            R.id.nav_share -> {
                val i = Intent(this@MainActivity, Tutorials::class.java)
                startActivity(i)
            }
            R.id.nav_send -> {
                val i = Intent(this@MainActivity, CustomerCare::class.java)
                startActivity(i)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    fun toPersonalDetails(view: View) {
        val intent = Intent(this, PerDetails::class.java)
        startActivity(intent)
    }

    fun toRegistationDetails(view: View) {
        val intent = Intent(this, RegistationDetails::class.java)
        startActivity(intent)
    }
    fun toPayment(view: View) {
        val intent = Intent(this, Payment::class.java)
        startActivity(intent)
    }

    fun toLessonList(view: View) {
        val intent = Intent(this, LessonList::class.java)
        startActivity(intent)
    }
    fun toTutorials(view: View) {
        val intent = Intent(this, Tutorials::class.java)
        startActivity(intent)
    }

    fun toCustomerCare(view: View) {
        val intent = Intent(this, CustomerCare::class.java)
        startActivity(intent)
    }
}
