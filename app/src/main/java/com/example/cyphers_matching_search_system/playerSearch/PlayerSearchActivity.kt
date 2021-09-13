package com.example.cyphers_matching_search_system.playerSearch

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.databinding.ActivityPlayerSearchBinding

class PlayerSearchActivity : AppCompatActivity() {

    private val viewModel: PlayerSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityPlayerSearchBinding>(this, R.layout.activity_player_search)
        binding.data = viewModel

    }

}