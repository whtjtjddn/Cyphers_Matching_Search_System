package com.example.cyphers_matching_search_system.matchingHistorySearch

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.databinding.ActivityMatchingHistorySearchBinding
import com.example.cyphers_matching_search_system.main.MainActivity2

class MatchingHistorySearchActivity : AppCompatActivity() {

    private val viewModel: MatchingHistorySearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        val binding = DataBindingUtil.setContentView<ActivityMatchingHistorySearchBinding>(this, R.layout.activity_matching_history_search)


        //adapter.notifyDataSetChange() refresh 하는 코드
        binding.data = viewModel

        val adapter = MatchingHistory_Recycler_Adapter()
        adapter!!.MatchingHistory_listData = viewModel.matching_data
        binding.matchingItem.adapter = adapter
        binding.matchingItem.layoutManager = LinearLayoutManager(this)
    }

}