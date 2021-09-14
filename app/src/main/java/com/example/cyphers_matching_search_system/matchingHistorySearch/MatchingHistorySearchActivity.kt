package com.example.cyphers_matching_search_system.matchingHistorySearch

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.databinding.ActivityMatchingHistorySearchBinding
import com.example.cyphers_matching_search_system.main.MainActivity2

class MatchingHistorySearchActivity : AppCompatActivity() {

    private val viewModel: MatchingHistorySearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMatchingHistorySearchBinding>(this, R.layout.activity_matching_history_search)
        binding.data = viewModel

        val searchBtn = findViewById<View>(R.id.SearchBtn)
        val info = findViewById<View>(R.id.Result)

        val intent = Intent(this, MainActivity2::class.java)

        searchBtn.setOnClickListener {
            intent.putExtra("info",info.get().toString())
            startActivity(intent)
        }

    }

}