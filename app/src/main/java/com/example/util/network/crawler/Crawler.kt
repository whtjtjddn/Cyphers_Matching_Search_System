package com.example.util.network.crawler

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.jsoup.Jsoup

class Crawler {

    @ExperimentalCoroutinesApi
    fun getAllBattleitemList() : Array<String>{
        val battleitemList = mutableListOf<String>()

        val battleitemURL = "http://cyphers.nexon.com/cyphers/game/item/itembox"
        val doc = Jsoup.connect(battleitemURL).get()
        val datas = doc.select("div.item_list").select("p.name").select("span")
        for (data in datas) {
            val battleitemName = data.text()
            battleitemList.add(battleitemName)
        }
        return battleitemList.toTypedArray()
    }
}