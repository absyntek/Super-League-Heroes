package com.super_league.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.super_league.heroes.databinding.ActivitySkyMapBinding

class SkyMapActivity : AppCompatActivity() {

    private lateinit var bind: ActivitySkyMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySkyMapBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}