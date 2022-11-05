package com.super_league.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.super_league.heroes.databinding.BtsHeroMenuBinding

class MenuBts : BottomSheetDialogFragment() {

    lateinit var bind : BtsHeroMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = BtsHeroMenuBinding.inflate(inflater, container, false)
        return bind.root
    }
}