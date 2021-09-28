package com.example.cyphers_matching_search_system.battleitemInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.util.network.responseBattleitemInfo.ResponseBattleitemInfo
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class BattleitemInfoViewModel : ViewModel() {

    var repository = BattleitemInfoRespository()

    private val _battleitemDataList= MutableLiveData<ArrayList<BattleitemData>>()
    val battleitemDataList : LiveData<ArrayList<BattleitemData>> = _battleitemDataList


    init {
        setBattleitemDataList()
    }

    private fun setBattleitemDataList(){
        viewModelScope.launch(Dispatchers.Default) {
            val items =  ArrayList<BattleitemData>()
            val deferred = async(Dispatchers.IO) {
                repository.getBattleitemlist()
            }

            val battleitemNameList = deferred.await()

            for (battleitemName in battleitemNameList){
                val battleitemInfo = getBattleitemInfo(battleitemName)
                val battleitemData = battleitemInfo?.let { convertBattleitemData(it) }
                battleitemData?.let { items.add(it) }
            }
            _battleitemDataList.postValue(items)
        }
    }

    private suspend fun getBattleitemInfo(battleitemName: String, delayTime : Long = 1): ResponseBattleitemInfo? {
        var data : ResponseBattleitemInfo ?= null
        repository.getBattleitemInfo(battleitemName,
            { data = it },
            { _, t ->
                //TODO Fail result
            }
        )
        delay(100 * delayTime)
        if (data == null)
            data = getBattleitemInfo(battleitemName, delayTime+1)
        return data
    }

    private fun convertBattleitemData(responseBattleitemInfo: ResponseBattleitemInfo): BattleitemData {
        val data  = BattleitemData("defaultUrl","defaultItemName")
        val defaultUrl = "https://img-api.neople.co.kr/cy/items/"
        data.itemIamge = defaultUrl + responseBattleitemInfo.rows[0].itemId
        data.itemName = responseBattleitemInfo.rows[0].itemName
        return data
    }
}