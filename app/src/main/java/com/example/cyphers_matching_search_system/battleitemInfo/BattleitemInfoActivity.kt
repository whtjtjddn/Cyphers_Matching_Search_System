package com.example.cyphers_matching_search_system.battleitemInfo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.databinding.ActivityBattleitemInfoBinding

class BattleitemInfoActivity : AppCompatActivity() {

    private val viewModel: BattleitemInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityBattleitemInfoBinding>(this, R.layout.activity_battleitem_info)
        binding.data = viewModel

    }
}
