package com.example.viewmodelpost.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewmodelpost.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onStart() {
        super.onStart()
        showScreenPost()
    }

    private fun showScreenPost() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, PostFragment(), PostFragment::class.java.simpleName)
            .commit()
    }

}