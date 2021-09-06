package com.example.util.network

import com.example.util.network.ResponsePlayerInfo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

import android.util.Log

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
}

public fun getCyphersConnector(): CyphersService{
    // Retrofit 인스턴스 생성
    return retrofit.create(CyphersService::class.java);
}

public fun CypherseConnection() {
    val cyphersConnector = getCyphersConnector();
    val callGetPlayerInfo = cyphersConnector.getPlayerInfo("FnaA38BJKLS69mQ9rDx6vEztIr8fbS3y", "리바리바리바", "match")
    val callGetPlayerInfoDetail = cyphersConnector.getPlayerInfoDetail("e852fa7278e9e3eeea97bd3775dcd287", "FnaA38BJKLS69mQ9rDx6vEztIr8fbS3y")
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

}