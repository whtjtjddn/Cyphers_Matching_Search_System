package com.example.cyphers_matching_search_system.battleitemInfo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.databinding.ActivityBattleitemInfoBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

class BattleitemInfoActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    private val viewModel: BattleitemInfoViewModel by viewModels()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityBattleitemInfoBinding>(this, R.layout.activity_battleitem_info)
        binding.data = viewModel
        binding.recycler.layoutManager = LinearLayoutManager(this)

        val battleitemAdapter = BattleitemAdapter(this)
        binding.recycler.adapter = battleitemAdapter

        viewModel.battleitemDataList.observe(this, Observer{
            battleitemAdapter.setData(it)
        })

    }
}
