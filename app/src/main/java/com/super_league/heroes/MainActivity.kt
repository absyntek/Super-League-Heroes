package com.super_league.heroes

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.super_league.heroes.databinding.ActivityMainBinding
import com.super_league.heroes.stardroid.activities.DynamicStarMapActivity
import com.super_league.heroes.stardroid.activities.SplashScreenActivity
import org.joda.time.DateTime

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        bind.btnMainMenu.setOnClickListener {
            startActivity(Intent(this, LoadingActivity::class.java))
        }
        bind.btnMainRadio.setOnClickListener {
            startActivity(Intent(this, RadioActivity::class.java))
        }

        /* TMP Buttons */
        bind.btnScanner.setOnClickListener {
            startActivity(Intent(this, DynamicStarMapActivity::class.java))
        }
        bind.btnTodo.setOnClickListener {
            startActivity(Intent(this, SannerActivity::class.java))
        }
        /* TMP Buttons */
        bind.tvTinyTime.text = DateTime().toString("HH : mm")
        bind.tvTimeNow.text = DateTime().toString("HH : mm")

        val color = ContextCompat.getColor(this, R.color.black)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            if (window.navigationBarColor != color) {
                val decorView = window.decorView
                val wic = WindowInsetsControllerCompat(window, decorView)
                wic.isAppearanceLightNavigationBars = false
                window.navigationBarColor = color
            }
        }

        setContentView(bind.root)
    }
}