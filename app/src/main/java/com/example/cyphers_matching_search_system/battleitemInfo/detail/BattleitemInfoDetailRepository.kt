package com.example.cyphers_matching_search_system.battleitemInfo.detail

import com.example.cyphers_matching_search_system.BuildConfig
import com.example.util.network.getCyphersConnector
import com.example.util.network.responseBattleitemInfoDetail.ResponseBattleitemInfoDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BattleitemInfoDetailRepository {

    fun getBattleitemInfoDetail(itemId: String,
            success: (ResponseBattleitemInfoDetail) -> Unit,
            error: (Call<ResponseBattleitemInfoDetail>, Throwable) -> Unit){

        val cyphersConnector = getCyphersConnector()
        val callGetBattleitemInfoDetail = cyphersConnector.getBattleitemInfoDetail(itemId, BuildConfig.NeopleAPIKey)

        callGetBattleitemInfoDetail.enqueue(object : Callback<ResponseBattleitemInfoDetail> {
            override fun onResponse(
                call: Call<ResponseBattleitemInfoDetail>,
                response: Response<ResponseBattleitemInfoDetail>
            ) {
                val data = response.body()
                data?.let { success(data) }
            }

            override fun onFailure(
                call: Call<ResponseBattleitemInfoDetail>,
                t: Throwable
            ) {
                error(callGetBattleitemInfoDetail, t)
            }
        })

    }
}