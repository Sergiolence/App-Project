package com.projectes.projectelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.projectes.projectelogin.db.DBHelper
import com.projectes.projectelogin.fragments.FormFragment
import com.projectes.projectelogin.fragments.Home
import com.projectes.projectelogin.fragments.ListFragment
import com.projectes.projectelogin.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var dbHelper:DBHelper;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView2)

        dbHelper = DBHelper(this)

        this.deleteDatabase("llibres.db")

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(Home())
                    true
                }
                R.id.nav_form -> {
                    loadFragment(FormFragment(dbHelper))
                    true
                }
                R.id.nav_list -> {
                    loadFragment(ListFragment(dbHelper))
                    true
                }
                else -> {false}
            }
        }
    }
    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

    fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_settings -> {
                loadFragment(SettingsFragment())
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}

