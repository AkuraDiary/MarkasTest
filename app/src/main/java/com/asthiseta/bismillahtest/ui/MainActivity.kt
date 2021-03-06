package com.asthiseta.bismillahtest.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.asthiseta.bismillahtest.R
import com.asthiseta.bismillahtest.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        //get the auth object
        auth = FirebaseAuth.getInstance()

        setSupportActionBar(mainBinding.toolbar)
        mainBinding.toolbar.apply {
            setBackgroundColor(resources.getColor(R.color.teal_200))
            setTitleTextColor(Color.WHITE)
            title = auth.currentUser?.email//getString(R.string.auth_usrname)
        }

        navController = findNavController(R.id.nav_host)
        NavigationUI.setupWithNavController(mainBinding.bottomNavView, navController)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        navController.addOnDestinationChangedListener{_, destination, _ ->
            when(destination.id){
                R.id.detail_destination -> mainBinding.bottomNavView.visibility = View.GONE
                else -> mainBinding.bottomNavView.visibility = View.VISIBLE
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp(appBarConfiguration)
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        auth.signOut()
        super.onDestroy()
    }
}