package com.example.cyphers_matching_search_system.battleitemInfo

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class BattleitemInfoViewModel : ViewModel() {

    var repository = BattleitemInfoRespository()
    var _battleitemListData = ObservableField<String>()

    @ExperimentalCoroutinesApi
    fun crawl(){
        viewModelScope.launch(Dispatchers.IO) {
            val crawlData = repository.getBattleitemlist()
            _battleitemListData.set(crawlData[0])
        }
    }

}