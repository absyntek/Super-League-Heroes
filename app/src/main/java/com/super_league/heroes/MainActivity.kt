package com.super_league.heroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.super_league.heroes.databinding.ActivityMainBinding
import com.super_league.heroes.stardroid.activities.DynamicStarMapActivity
import com.super_league.heroes.stardroid.activities.SplashScreenActivity

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        bind.btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
        bind.btnRadio.setOnClickListener {
            startActivity(Intent(this, RadioActivity::class.java))
        }
        bind.btnScanner.setOnClickListener {
            startActivity(Intent(this, DynamicStarMapActivity::class.java))
        }
        bind.btnTodo.setOnClickListener {
            startActivity(Intent(this, SannerActivity::class.java))
        }
        setContentView(bind.root)
    }
}