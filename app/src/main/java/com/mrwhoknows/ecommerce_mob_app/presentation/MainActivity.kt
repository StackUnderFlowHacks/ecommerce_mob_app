package com.mrwhoknows.ecommerce_mob_app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrwhoknows.ecommerce_mob_app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
