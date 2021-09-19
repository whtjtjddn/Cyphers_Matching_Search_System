package com.example.cyphers_matching_search_system.battleitemInfo

import com.example.cyphers_matching_search_system.BuildConfig
import com.example.util.network.crawler.Crawler
import com.example.util.network.getCyphersConnector
import com.example.util.network.responseBattleitemInfo.ResponseBattleitemInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BattleitemInfoRespository {
    @ExperimentalCoroutinesApi
    suspend fun getBattleitemlist() : Array<String>{
        val crawler = Crawler()
        val battleitemlist = crawler.getAllBattleitemList()
        return withContext(Dispatchers.IO){
            battleitemlist
        }
    }


    fun getBattleitemInfo(
        itemName: String,
        success: (ResponseBattleitemInfo) -> Unit,
        error: (Call<ResponseBattleitemInfo>, Throwable) -> Unit){

        val cyphersConnector = getCyphersConnector()
        val callGetBattleitemInfo = cyphersConnector.getBattleitemInfo(itemName, BuildConfig.NeopleAPIKey)

        callGetBattleitemInfo.enqueue(object : Callback<ResponseBattleitemInfo> {
            override fun onResponse(
                call: Call<ResponseBattleitemInfo>,
                response: Response<ResponseBattleitemInfo>
            ) {
                val data = response.body()
                data?.let { success(data) }
            }

            override fun onFailure(
                call: Call<ResponseBattleitemInfo>,
                t: Throwable
            ) {
                error(callGetBattleitemInfo, t)
            }
        })

    }
}
