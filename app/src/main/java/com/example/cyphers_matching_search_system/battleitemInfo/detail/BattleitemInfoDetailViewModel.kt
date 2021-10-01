package com.example.cyphers_matching_search_system.battleitemInfo.detail

import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.cyphers_matching_search_system.R

class BattleitemInfoDetailViewModel: ViewModel() {

    var repository : BattleitemInfoDetailRepository = BattleitemInfoDetailRepository()
    var _battleitemImage = ObservableField("")
    var _battleitemName = ObservableField<String>()
    var _battleitemExplain = ObservableField<String>()
    var _battleitemExplainDetail = ObservableField<String>()
    var _battleitemNameColor = ObservableField(R.color.black)

    fun loadData(battleitemId: String){
        val defaultUrl = "https://img-api.neople.co.kr/cy/items/"
        repository.getBattleitemInfoDetail(battleitemId,
            {
                _battleitemImage.set(defaultUrl+it.itemId)
                _battleitemName.set(it.itemName)
                _battleitemNameColor.set(choiceColor(it.rarityCode))
                _battleitemExplain.set("${it.characterName} 전용\n${it.slotName}\n${it.rarityName}")
                _battleitemExplainDetail.set(it.explain)
            },
            {_, t ->
                run { _battleitemExplainDetail.set("error:" + t.message) }
            }
        )
    }

    @SuppressLint("ResourceAsColor")
    fun choiceColor(rarity: String): Int {
        var color = R.color.black
        when (rarity) {
            "101" -> color = R.color.common
            "102" -> color = R.color.uncommon
            "103" -> color = R.color.rare
            "104" -> color = R.color.unique
        }
        return color
    }

}