package com.example.cyphers_matching_search_system.matchingHistorySearch

import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.cyphers_matching_search_system.matchingHistorySearch.MatchingHistorySearchRepository


class MatchingHistorySearchViewModel: ViewModel() {

    var repository : MatchingHistorySearchRepository = MatchingHistorySearchRepository()
    var _playerId = ObservableField<String>()
    var _playerMatchingInfo = ObservableField<String>()

    fun search(){
        val playerNickname = _playerId.get().toString()
        repository.getPlayerMatchingHistory(playerNickname,
            {
                _playerMatchingInfo.set(it.toString())}
        ) { _, t ->
            run { _playerMatchingInfo.set("error:" + t.message) }
        }



    }

}
