package com.example.util.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

import android.util.Log
import com.example.cyphers_matching_search_system.BuildConfig
import com.example.util.network.responsePlayerInfo.ResponsePlayerInfo
import com.example.util.network.responsePlayerInfoDetail.ResponsePlayerInfoDetail
import com.example.util.network.responsePlayerMatchingHistory.ResponsePlayerMatchingHistory
import com.example.util.network.responseMatchingInfo.ResponseMatchingInfo
import java.util.*

private var retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl("https://api.neople.co.kr/cy/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();



public interface CyphersService {
    // 호출할 메서드를 선언하는 인터페이스

    @GET("players")
    fun getPlayerInfo(
            @Query("apikey") CyphersAPIKey: String,
            @Query("nickname") nickname: String,
            @Query("wordType") wordType: String?,
            @Query("limit") limit: Int? = null,
    ): Call<ResponsePlayerInfo>

    @GET("players/{playerId}")
    fun getPlayerInfoDetail(
        @Path("playerId") playerId: String,
        @Query("apikey") CyphersAPIKey: String
    ): Call<ResponsePlayerInfoDetail>


    @GET("players/{playerId}/matches")
    fun getPlayerMatchingHistory(
        @Path("playerId") playerId: String,
        @Query("apikey") CyphersAPIKey: String,
        @Query("gameTypeId") gameTypeId: String? = null,
        @Query("startDate") startDate: Date? = null,
        @Query("endDate") endDate: Date? = null,
        @Query("limit") limit: Int? = null,
        @Query("next") next: String? = null
    ): Call<ResponsePlayerMatchingHistory>


    @GET("matches/{matchId}")
    fun getMatchingInfo(
        @Path("matchId") matchId: String,
        @Query("apikey") CyphersAPIKey: String,
    ): Call<ResponseMatchingInfo>

}

public fun getCyphersConnector(): CyphersService{
    // Retrofit 인스턴스 생성
    return retrofit.create(CyphersService::class.java);
}

public fun CypherseConnection() {
    //TODO 나중에 숨겨야하는 데이터
    val API_KEY = BuildConfig.NeopleAPIKey

    //TODO 동작 확인용 임시 데이터
    val playerNickname = "리바리바리바"
    val playerId = "e852fa7278e9e3eeea97bd3775dcd287"
    val matchId = "9380a5e4267db146c49f71bb123096ee214eabae92b5c868e554b7374431e18b"

    val cyphersConnector = getCyphersConnector();
    val callGetPlayerInfo = cyphersConnector.getPlayerInfo(API_KEY, playerNickname, "match")
    val callGetPlayerInfoDetail = cyphersConnector.getPlayerInfoDetail(playerId, API_KEY)
    val callGetPlayerMatchingHistory = cyphersConnector.getPlayerMatchingHistory(playerId, API_KEY)
    val callGetMatchingInfo = cyphersConnector.getMatchingInfo(matchId, API_KEY)
    val TAG = "riba"

    callGetPlayerInfo.enqueue(object : Callback<ResponsePlayerInfo> {
        override fun onResponse(
            call: Call<ResponsePlayerInfo>,
            response: Response<ResponsePlayerInfo>
        ) {
            Log.d(TAG, "플레이어 검색 성공 : ${response.raw()}")
            Log.d(TAG, "플레이어 검색 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponsePlayerInfo>,
            t: Throwable
        ) {
            Log.d(TAG, "플레이어 검색 실패 : $t")
        }
    })


    callGetPlayerInfoDetail.enqueue(object : Callback<ResponsePlayerInfoDetail> {
        override fun onResponse(
            call: Call<ResponsePlayerInfoDetail>,
            response: Response<ResponsePlayerInfoDetail>
        ) {
            Log.d(TAG, "플레이어 정보 성공 : ${response.raw()}")
            Log.d(TAG, "플레이어 정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponsePlayerInfoDetail>,
            t: Throwable
        ) {
            Log.d(TAG, "플레이어 정보 실패 : $t")
        }
    })


    callGetPlayerMatchingHistory.enqueue(object : Callback<ResponsePlayerMatchingHistory> {
        override fun onResponse(
            call: Call<ResponsePlayerMatchingHistory>,
            response: Response<ResponsePlayerMatchingHistory>
        ) {
            Log.d(TAG, "플레이어 매칭정보 성공 : ${response.raw()}")
            Log.d(TAG, "플레이어 매칭정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponsePlayerMatchingHistory>,
            t: Throwable
        ) {
            Log.d(TAG, "플레이어 매칭정보 실패 : $t")
        }
    })



    callGetMatchingInfo.enqueue(object : Callback<ResponseMatchingInfo> {
        override fun onResponse(
            call: Call<ResponseMatchingInfo>,
            response: Response<ResponseMatchingInfo>
        ) {
            Log.d(TAG, "매칭 상세 정보 성공 : ${response.raw()}")
            Log.d(TAG, "매칭 상세 정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseMatchingInfo>,
            t: Throwable
        ) {
            Log.d(TAG, "매칭 상세 정보 실패 : $t")
        }
    })

}