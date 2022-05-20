package com.example.drawermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.drawermenu.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toogle:ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.navView)

            toogle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
            drawerLayout.addDrawerListener(toogle)
            toogle.syncState()

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.pageFive -> Toast.makeText(applicationContext,"click",Toast.LENGTH_LONG).show()
            }
            true
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.button.setOnClickListener {
            openCloseNavigationDrawer(it)

        }

    }

    fun openCloseNavigationDrawer(view: View) {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }


}