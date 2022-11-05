package com.super_league.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.super_league.heroes.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMenuBinding.inflate(layoutInflater)

        bind.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId){
                R.id.menu_item_dim -> {
                    val bts = MenuBts()
                    bts.show(supportFragmentManager, null)
                    true
                }
                else -> false
            }
        }
        setContentView(bind.root)
    }
}