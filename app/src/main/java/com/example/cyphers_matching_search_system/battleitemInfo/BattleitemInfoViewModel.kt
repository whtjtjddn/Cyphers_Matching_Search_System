package com.example.cyphers_matching_search_system.battleitemInfo

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.util.network.responseBattleitemInfo.ResponseBattleitemInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class BattleitemInfoViewModel : ViewModel() {

    var repository = BattleitemInfoRespository()
    var _battleitemListData = ObservableField<String>()

    fun getBattleitemInfo(battleitemName: String): ResponseBattleitemInfo? {
        var data : ResponseBattleitemInfo ?= null
        repository.getBattleitemInfo(battleitemName,
            { data = it },
            { _, t ->
                //TODO Fail result
            }
        )
        return data
    }

    fun convertBattleitemData(responseBattleitemInfo: ResponseBattleitemInfo): BattleitemData {
        val data  = BattleitemData("defaultUrl","defaultItemName")
        val defaultUrl = "https://img-api.neople.co.kr/cy/items/"
        data.itemIamge = defaultUrl + responseBattleitemInfo.rows[0].itemId
        data.itemName = responseBattleitemInfo.rows[0].itemName
        return data
    }

    fun getBattleitemData(){

    }

    @ExperimentalCoroutinesApi
    fun crawl() {
        viewModelScope.launch(Dispatchers.IO) {
            val crawlData = repository.getBattleitemlist()
            _battleitemListData.set(crawlData[0])
        }
    }

}