package com.example.cyphers_matching_search_system.playerSearch

import com.example.cyphers_matching_search_system.BuildConfig
import com.example.util.network.getCyphersConnector
import com.example.util.network.responsePlayerInfo.ResponsePlayerInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlayerSearchRepository {

    fun getPlayerInfo(playerNickname: String,
            success: (ResponsePlayerInfo) -> Unit,
            error: (Call<ResponsePlayerInfo>, Throwable) -> Unit){

        val cyphersConnector = getCyphersConnector()
        val callGetPlayerInfo = cyphersConnector.getPlayerInfo(BuildConfig.NeopleAPIKey, playerNickname)

        callGetPlayerInfo.enqueue(object :Callback<ResponsePlayerInfo>{
            override fun onResponse(
                call: Call<ResponsePlayerInfo>,
                response: Response<ResponsePlayerInfo>
            ) {
                val data = response.body()
                data?.let { success(data) }
            }

            override fun onFailure(
                call: Call<ResponsePlayerInfo>,
                t: Throwable
            ) {
                error(callGetPlayerInfo, t)
            }
        })

    }
}
