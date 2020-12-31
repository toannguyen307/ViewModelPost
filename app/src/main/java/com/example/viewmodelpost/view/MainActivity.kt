package com.example.viewmodelpost.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.viewmodelpost.R
import com.example.viewmodelpost.di.component.ApplicationComponent
import com.example.viewmodelpost.di.component.DaggerApplicationComponent
import com.example.viewmodelpost.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.main_nav))
    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_nav).navigateUp()
}