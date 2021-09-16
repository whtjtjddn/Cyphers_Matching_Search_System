package com.example.cyphers_matching_search_system.battleitemInfo

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BattleitemInfoViewModel : ViewModel() {

    var repository : BattleitemInfoRespository = BattleitemInfoRespository()
    var _battleitemListData = ObservableField<String>()

    fun crawl(){
        viewModelScope.launch(Dispatchers.IO) {
            val crawlData = repository.getBattleitemlist()
            Log.d("riba", crawlData.size.toString())
            Log.d("riba", "crawlData[0]")
            _battleitemListData.set(crawlData[0])
            Log.d("riba", crawlData[0])
        }
    }

}