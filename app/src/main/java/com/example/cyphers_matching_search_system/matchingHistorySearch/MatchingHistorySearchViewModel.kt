package com.example.cyphers_matching_search_system.matchingHistorySearch

import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.cyphers_matching_search_system.matchingHistorySearch.MatchingHistorySearchRepository


class MatchingHistorySearchViewModel: ViewModel() {

    var repository : MatchingHistorySearchRepository = MatchingHistorySearchRepository()
    var _playerId = "e852fa7278e9e3eeea97bd3775dcd287"
    var _playerGrade = ObservableField<String>()
    var _playerClan = ObservableField<String>()
    var _playerTier = ObservableField<String>()
    fun search(){
        val playerNickname = _playerId
        repository.getPlayerMatchingHistory(playerNickname,
            {
                _playerClan.set("클랜명 : " + it.clanName.toString())
                _playerGrade.set(it.grade.toString() + "급  " + it.nickname.toString())
                _playerTier.set(it.ratingPoint.toString() + "\n" + it.tierName.toString())
            }
        ) { _, t ->
            run { _playerGrade.set("error:" + t.message) }
        }



    }

}
