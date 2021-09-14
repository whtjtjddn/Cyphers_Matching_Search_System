package com.example.cyphers_matching_search_system.matchingHistorySearch

import android.util.Log
import com.example.cyphers_matching_search_system.BuildConfig
import com.example.util.network.getCyphersConnector
import com.example.util.network.responsePlayerInfo.ResponsePlayerInfo
import com.example.util.network.responsePlayerMatchingHistory.ResponsePlayerMatchingHistory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MatchingHistorySearchRepository {

    fun getPlayerMatchingHistory(playerId: String,
                                 success: (ResponsePlayerMatchingHistory) -> Unit,
                                 error: (Call<ResponsePlayerMatchingHistory>, Throwable) -> Unit) {

        val cyphersConnector = getCyphersConnector()
        val callGetPlayerMatchingHistory = cyphersConnector.getPlayerMatchingHistory(playerId, BuildConfig.NeopleAPIKey)

        callGetPlayerMatchingHistory.enqueue(object : Callback<ResponsePlayerMatchingHistory> {
            override fun onResponse(
                call: Call<ResponsePlayerMatchingHistory>,
                response: Response<ResponsePlayerMatchingHistory>
            ) {
                val data = response.body()
                data?.let { success(data) }
            }

            override fun onFailure(
                call: Call<ResponsePlayerMatchingHistory>,
                t: Throwable
            ) {
                Log.d("riba", "플레이어 매칭정보 실패 : $t")
            }
        })
    }

}

