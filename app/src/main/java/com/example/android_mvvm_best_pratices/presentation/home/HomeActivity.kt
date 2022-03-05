package com.example.android_mvvm_best_pratices.presentation.home

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android_mvvm_best_pratices.ADMIN_WORD
import com.example.android_mvvm_best_pratices.R
import com.example.android_mvvm_best_pratices.ROLES_KEY
import com.example.android_mvvm_best_pratices.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val roles = sharedPreferences.getStringSet(ROLES_KEY, setOf())

        navView.menu.findItem(R.id.add_movie).isVisible = false
        roles?.forEach {
            if (it.contains(ADMIN_WORD))
                navView.menu.findItem(R.id.add_movie).isVisible = true
        }

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_movies, R.id.add_movie, R.id.nav_about, R.id.nav_logout
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}