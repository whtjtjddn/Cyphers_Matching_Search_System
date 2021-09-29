package com.example.cyphers_matching_search_system.battleitemInfo.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class BattleitemInfoDetailViewModel: ViewModel() {

    var repository : BattleitemInfoDetailRepository = BattleitemInfoDetailRepository()
    var _battleitemImage = ObservableField("")
    var _battleitemName = ObservableField<String>()
    var _battleitemExplain = ObservableField<String>()
    var _battleitemExplainDetail = ObservableField<String>()

    fun loadData(battleitemId: String){
        val defaultUrl = "https://img-api.neople.co.kr/cy/items/"
        repository.getBattleitemInfoDetail(battleitemId,
            {
                _battleitemImage.set(defaultUrl+it.itemId)
                _battleitemName.set(it.itemName)
                _battleitemExplain.set(it.explain)
                _battleitemExplainDetail.set(it.explainDetail)
            },
            {_, t ->
                run { _battleitemExplainDetail.set("error:" + t.message) }
            }
        )
    }

}