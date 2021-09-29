package com.example.cyphers_matching_search_system.battleitemInfo.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.databinding.PopupBattleitemInfoDetailBinding

class BattleitemInfoDetailPopup : AppCompatActivity(){

    private val viewModel: BattleitemInfoDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val battleitemId= intent?.getStringExtra("battleitemId").toString()

        val binding = DataBindingUtil.setContentView<PopupBattleitemInfoDetailBinding>(this, R.layout.popup_battleitem_info_detail)
        binding.data = viewModel

        viewModel.loadData(battleitemId)

    }
}