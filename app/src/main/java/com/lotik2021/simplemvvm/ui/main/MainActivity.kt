package com.lotik2021.simplemvvm.ui.main

import android.os.Bundle
import com.lotik2021.simplemvvm.R
import dagger.android.support.DaggerAppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}