package com.example.viewmodelpost.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.viewmodelpost.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav) as NavHostFragment
//        val navController= navHostFragment.navController
//        navController.navigateUp()
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this,findNavController(R.id.main_nav))
    }
  override fun onSupportNavigateUp() = findNavController(R.id.main_nav).navigateUp()
}