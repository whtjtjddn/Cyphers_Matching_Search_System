package com.example.cyphers_matching_search_system.playerSearch

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel


class PlayerSearchViewModel: ViewModel() {

    var repository : PlayerSearchRepository = PlayerSearchRepository()
    var _playerNickname = ObservableField<String>()
    var _playerInfoData = ObservableField<String>()

    fun search(){
        val playerNickname = _playerNickname.get().toString()
        repository.getPlayerInfo(playerNickname,
            {_playerInfoData.set(it.toString())},
            {_, t ->
                run { _playerInfoData.set("error:" + t.message) }
            }
        )
    }

}
