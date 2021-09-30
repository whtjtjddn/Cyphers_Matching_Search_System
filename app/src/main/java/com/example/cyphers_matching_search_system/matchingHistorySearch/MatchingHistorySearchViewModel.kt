package com.example.cyphers_matching_search_system.matchingHistorySearch

import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.databinding.ActivityMatchingHistorySearchBinding
import com.example.cyphers_matching_search_system.matchingHistorySearch.MatchingHistorySearchRepository
import com.example.util.network.responsePlayerInfo.ResponsePlayerInfo


class MatchingHistorySearchViewModel: ViewModel() {

    var repository : MatchingHistorySearchRepository = MatchingHistorySearchRepository()
    var _playerNickname = ObservableField<String>()
    var _playerId = ""
    var _playerGrade = ObservableField<String>()
    var _playerClan = ObservableField<String>()
    var _playerTier = ObservableField<String>()
    private val data:MutableList<MatchingHIstory_Recycler_Item> = mutableListOf()
    fun search(){
        val playerNickname = _playerNickname.get().toString()

        repository.getPlayerInfo(playerNickname,
            {
                _playerId = it.rows[0].playerId
                println(it.rows.toString())},
            {_, t ->
                run {}
            }
        )
        val playerId = _playerId

        repository.getPlayerMatchingHistory(playerId,
            {
                _playerClan.set("클랜명 : " + it.clanName.toString())
                _playerGrade.set(it.grade.toString() + "급  " + it.nickname.toString())
                _playerTier.set(it.ratingPoint.toString() + "\n\n" + it.tierName.toString())
            }
        ) { _, t ->
            run { _playerGrade.set("error:" + t.message) }
        }

        val binding = DataBindingUtil.setContentView<ActivityMatchingHistorySearchBinding>(this, R.layout.activity_matching_history_search)

        with(data){
            add(MatchingHIstory_Recycler_Item("Member1"))
            add(MatchingHIstory_Recycler_Item("Member2"))
            add(MatchingHIstory_Recycler_Item("Member3"))
        }

        val adapter = MatchingHistory_Recycler_Adapter()
        adapter!!.MatchingHistory_listData = data
        binding.matchingItem.adapter = adapter
        binding.matchingItem.layoutManager = LinearLayoutManager(this)
    }
}
