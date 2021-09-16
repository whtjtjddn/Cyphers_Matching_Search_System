package com.example.cyphers_matching_search_system.battleitemInfo

import com.example.util.network.crawler.Crawler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BattleitemInfoRespository {
    suspend fun getBattleitemlist() : Array<String>{
        val crawler = Crawler()
        val battleitemlist = crawler.getAllBattleitemList()
        return withContext(Dispatchers.IO){
            battleitemlist
        }
    }
}