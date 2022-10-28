package com.super_league.heroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.super_league.heroes.utils.myTimer

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        myTimer(4000){
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}