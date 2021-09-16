package com.example.util.network.crawler

import android.util.Log
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.jsoup.Jsoup

class Crawler {

    @ExperimentalCoroutinesApi
    fun getAllBattleitemList() : Array<String>{
        val battleitemList = mutableListOf<String>()
        Log.d("riba", "????")

        val battleitemURL = "http://cyphers.nexon.com/cyphers/game/item/itembox"
        val doc = Jsoup.connect(battleitemURL).get()
        val datas = doc.select("div.item_list")
        for (data in datas) {
            val battleitemName = data.select("p.name").select("span").text()
            battleitemList.add(battleitemName)
        }
        return battleitemList.toTypedArray()
    }
}