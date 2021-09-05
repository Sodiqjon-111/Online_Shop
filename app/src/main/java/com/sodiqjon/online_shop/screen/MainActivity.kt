package com.sodiqjon.online_shop.screen

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.orhanobut.hawk.Hawk
import com.sodiqjon.online_shop.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    private lateinit var navigationController: NavController
    private lateinit var listener: NavController.OnDestinationChangedListener
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Hawk.init(this).build()

        navigationController = findNavController(R.id.fragment)
        bottom_navigation.setupWithNavController(navigationController)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView.setupWithNavController(navigationController)


        appBarConfiguration = AppBarConfiguration(navigationController.graph, drawerLayout)

        //setupActionBarWithNavController(navigationController, appBarConfiguration)
        listener =
            NavController.OnDestinationChangedListener { controller, destination, arguments ->
                if (destination.id == R.id.homeFragment) {
                    window.statusBarColor = ContextCompat.getColor(this, R.color.main)
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_500)))
                    supportActionBar?.setTitle("Driver App")
                } else if (destination.id == R.id.detailFragment) {
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_200)))
                }


            }

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)

        return navController.navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp()
    }

    override fun onPause() {

        super.onPause()
        navigationController.removeOnDestinationChangedListener(listener)
    }

    override fun onResume() {
        super.onResume()
        navigationController.addOnDestinationChangedListener(listener)
    }


}
