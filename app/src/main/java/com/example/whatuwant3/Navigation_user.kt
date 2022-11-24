package com.example.whatuwant3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
class Navigation_user : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_user)
        val services : ImageButton= findViewById(R.id.services)
        val locations : ImageButton= findViewById(R.id.locations)
        services.setOnClickListener()
        {
            val Intent = Intent(this, menu::class.java)
            startActivity(Intent)
        }
        locations.setOnClickListener()
        {
            val Intent = Intent(this, Abalibility::class.java)
            startActivity(Intent)
        }
        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.nav_home ->
                {
                    val Intent = Intent(this, Navigation_user::class.java)
                    startActivity(Intent)
                }
                R.id.nav_cancel ->
                {
                    val Intent = Intent(this, DeleteRequest::class.java)
                    startActivity(Intent)
                }
                R.id.nav_track -> {
                    val Intent = Intent(this, Track_application::class.java)
                    startActivity(Intent)
                }
                R.id.nav_logout ->
                {

                    val Intent = Intent(this, Login::class.java)
                    startActivity(Intent)
                }

                R.id.nav_setting -> {
                }
                R.id.nav_rate_us -> {
                }
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}