package com.example.util.network

import android.graphics.ColorSpace
import android.provider.ContactsContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

import android.util.Log
import com.example.cyphers_matching_search_system.BuildConfig
import com.example.util.network.responseBattleitemInfo.ResponseBattleitemInfo
import com.example.util.network.responseBattleitemInfoDetail.ResponseBattleitemInfoDetail
import com.example.util.network.responseBattleitemInfoDetailMulti.ResponseBattleitemInfoDetailMulti
import com.example.util.network.responseCharacterInfo.ResponseCharacterInfo
import com.example.util.network.responseCharacterRanking.ResponseCharacterRanking
import com.example.util.network.responsePlayerInfo.ResponsePlayerInfo
import com.example.util.network.responsePlayerInfoDetail.ResponsePlayerInfoDetail
import com.example.util.network.responsePlayerMatchingHistory.ResponsePlayerMatchingHistory
import com.example.util.network.responseMatchingInfo.ResponseMatchingInfo
import com.example.util.network.responsePositionAttribute.ResponsePositionAttribute
import com.example.util.network.responseTSJRanking.ResponseTSJRanking
import com.example.util.network.responseTotalRanking.ResponseTotalRanking
import java.util.*
import kotlin.reflect.typeOf

private var retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl("https://api.neople.co.kr/cy/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();



public interface CyphersService {
    // 호출할 메서드를 선언하는 인터페이스

    @GET("players")
    fun getPlayerInfo(
            @Query("apikey") NeopleAPIKey: String,
            @Query("nickname") nickname: String,
            @Query("wordType") wordType: String? = null,
            @Query("limit") limit: Int? = null,
    ): Call<ResponsePlayerInfo>

    @GET("players/{playerId}")
    fun getPlayerInfoDetail(
        @Path("playerId") playerId: String,
        @Query("apikey") NeopleAPIKey: String
    ): Call<ResponsePlayerInfoDetail>


    @GET("players/{playerId}/matches")
    fun getPlayerMatchingHistory(
        @Path("playerId") playerId: String,
        @Query("apikey") NeopleAPIKey: String,
        @Query("gameTypeId") gameTypeId: String? = null,
        @Query("startDate") startDate: Date? = null,
        @Query("endDate") endDate: Date? = null,
        @Query("limit") limit: Int? = null,
        @Query("next") next: String? = null
    ): Call<ResponsePlayerMatchingHistory>


    @GET("matches/{matchId}")
    fun getMatchingInfo(
        @Path("matchId") matchId: String,
        @Query("apikey") NeopleAPIKey: String,
    ): Call<ResponseMatchingInfo>


    @GET("ranking/ratingpoint")
    fun getTotalRanking(
        @Query("apikey") NeopleAPIKey: String,
        @Query("playerId") playerId: String? = null,
        @Query("offset") offset: Int? = null,
        @Query("limit") limit: Int? = null,
    ): Call<ResponseTotalRanking>


    @GET("ranking/characters/{characterId}/{rankingType}")
    fun getCharacterRanking(
        @Path("characterId") CharacterId: String,
        @Path("rankingType") rankingType: String,
        @Query("apikey") NeopleAPIKey: String,
        @Query("playerId") playerId: String? = null,
        @Query("offset") offset: Int? = null,
        @Query("limit") limit: Int? = null,
    ): Call<ResponseCharacterRanking>

    @GET("ranking/tsj/{tsjType}")
    fun getTSJRanking(
        @Path("tsjType") tsjType: String,
        @Query("apikey") NeopleAPIKey: String,
        @Query("playerId") playerId: String? = null,
        @Query("offset") offset: Int? = null,
        @Query("limit") limit: Int? = null,
    ): Call<ResponseTSJRanking>


    @GET("battleitems")
    fun getBattleitemInfo(
        // TODO 'q= '파라미터 추가
        @Query("itemName") itemName: String,
        @Query("apikey") NeopleAPIKey: String,
        @Query("wordType") wordType: String? = null,
        @Query("offset") offset: Int? = null,
        @Query("limit") limit: Int? = null,
    ): Call<ResponseBattleitemInfo>


    @GET("battleitems/{itemId}")
    fun getBattleitemInfoDetail(
        @Path("itemId") itemId: String,
        @Query("apikey") NeopleAPIKey: String,
    ): Call<ResponseBattleitemInfoDetail>


    @GET("multi/battleitems")
    fun getBattleitemInfoDetailMulti(
        @Query("itemIds") itemId: String,
        @Query("apikey") NeopleAPIKey: String,
    ): Call<ResponseBattleitemInfoDetailMulti>


    @GET("characters")
    fun getCharacterInfo(
        @Query("apikey") NeopleAPIKey: String,
    ): Call<ResponseCharacterInfo>

    @GET("position-attributes/{attributeId}")
    fun getPositionAttribute(
        @Path("attributeId") attributeId: String,
        @Query("apikey") NeopleAPIKey: String,
    ): Call<ResponsePositionAttribute>
}

public fun getCyphersConnector(): CyphersService{
    // Retrofit 인스턴스 생성
    return retrofit.create(CyphersService::class.java);
}



public fun getPlayerInfoDetail(cyphersConnector: CyphersService, playerId: String){

    val callGetPlayerInfoDetail = cyphersConnector.getPlayerInfoDetail(playerId, BuildConfig.NeopleAPIKey)

    callGetPlayerInfoDetail.enqueue(object : Callback<ResponsePlayerInfoDetail> {
        override fun onResponse(
            call: Call<ResponsePlayerInfoDetail>,
            response: Response<ResponsePlayerInfoDetail>
        ) {
            Log.d("riba", "플레이어 정보 성공 : ${response.raw()}")
            Log.d("riba", "플레이어 정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponsePlayerInfoDetail>,
            t: Throwable
        ) {
            Log.d("riba", "플레이어 정보 실패 : $t")
        }
    })
}

public fun getPlayerMatchingHistory(cyphersConnector: CyphersService, playerId: String){


    val callGetPlayerMatchingHistory = cyphersConnector.getPlayerMatchingHistory(playerId, BuildConfig.NeopleAPIKey)

    callGetPlayerMatchingHistory.enqueue(object : Callback<ResponsePlayerMatchingHistory> {
        override fun onResponse(
            call: Call<ResponsePlayerMatchingHistory>,
            response: Response<ResponsePlayerMatchingHistory>
        ) {
            Log.d("riba", "플레이어 매칭정보 성공 : ${response.raw()}")
            Log.d("riba", "플레이어 매칭정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponsePlayerMatchingHistory>,
            t: Throwable
        ) {
            Log.d("riba", "플레이어 매칭정보 실패 : $t")
        }
    })
}

public fun getMatchingInfo(cyphersConnector: CyphersService, matchId: String){

    val callGetMatchingInfo = cyphersConnector.getMatchingInfo(matchId, BuildConfig.NeopleAPIKey)

    callGetMatchingInfo.enqueue(object : Callback<ResponseMatchingInfo> {
        override fun onResponse(
            call: Call<ResponseMatchingInfo>,
            response: Response<ResponseMatchingInfo>
        ) {
            Log.d("riba", "매칭 상세 정보 성공 : ${response.raw()}")
            Log.d("riba", "매칭 상세 정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseMatchingInfo>,
            t: Throwable
        ) {
            Log.d("riba", "매칭 상세 정보 실패 : $t")
        }
    })
}

public fun getTotalRanking(cyphersConnector: CyphersService){

    val callGetTotalRanking = cyphersConnector.getTotalRanking(BuildConfig.NeopleAPIKey)

    callGetTotalRanking.enqueue(object : Callback<ResponseTotalRanking> {
        override fun onResponse(
            call: Call<ResponseTotalRanking>,
            response: Response<ResponseTotalRanking>
        ) {
            Log.d("riba", "통합 랭킹 성공 : ${response.raw()}")
            Log.d("riba", "통합 랭킹 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseTotalRanking>,
            t: Throwable
        ) {
            Log.d("riba", "통합 랭킹 실패 : $t")
        }
    })

}


public fun getCharacterRanking(cyphersConnector: CyphersService, characterId : String){

    val callGetCharacterRanking = cyphersConnector.getCharacterRanking(characterId, "winCount", BuildConfig.NeopleAPIKey)

    callGetCharacterRanking.enqueue(object : Callback<ResponseCharacterRanking> {
        override fun onResponse(
            call: Call<ResponseCharacterRanking>,
            response: Response<ResponseCharacterRanking>
        ) {
            Log.d("riba", "캐릭터 랭킹 성공 : ${response.raw()}")
            Log.d("riba", "캐릭터 랭킹 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseCharacterRanking>,
            t: Throwable
        ) {
            Log.d("riba", "캐릭터 랭킹 실패 : $t")
        }
    })
}

public fun getTSJRanking(cyphersConnector: CyphersService){

    val callGetTSJRanking = cyphersConnector.getTSJRanking("melee", BuildConfig.NeopleAPIKey)

    callGetTSJRanking.enqueue(object : Callback<ResponseTSJRanking> {
        override fun onResponse(
            call: Call<ResponseTSJRanking>,
            response: Response<ResponseTSJRanking>
        ) {
            Log.d("riba", "투신전 랭킹 성공 : ${response.raw()}")
            Log.d("riba", "투신전 랭킹 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseTSJRanking>,
            t: Throwable
        ) {
            Log.d("riba", "투신전 랭킹 실패 : $t")
        }
    })
}

public fun getBattleitemInfo(cyphersConnector: CyphersService, itemName: String){

    val callGetBattleitemInfo = cyphersConnector.getBattleitemInfo(itemName, BuildConfig.NeopleAPIKey)

    callGetBattleitemInfo.enqueue(object : Callback<ResponseBattleitemInfo> {
        override fun onResponse(
            call: Call<ResponseBattleitemInfo>,
            response: Response<ResponseBattleitemInfo>
        ) {
            Log.d("riba", "아이템 정보 성공 : ${response.raw()}")
            Log.d("riba", "아이템 정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseBattleitemInfo>,
            t: Throwable
        ) {
            Log.d("riba", "아이템 정보 실패 : $t")
        }
    })

}

public fun getBattleitemInfoDetail(cyphersConnector: CyphersService, itemId: String){

    val callGetBattleitemInfoDetail = cyphersConnector.getBattleitemInfoDetail(itemId, BuildConfig.NeopleAPIKey)

    callGetBattleitemInfoDetail.enqueue(object : Callback<ResponseBattleitemInfoDetail> {
        override fun onResponse(
            call: Call<ResponseBattleitemInfoDetail>,
            response: Response<ResponseBattleitemInfoDetail>
        ) {
            Log.d("riba", "아이템 상세 정보 성공 : ${response.raw()}")
            Log.d("riba", "아이템 상세 정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseBattleitemInfoDetail>,
            t: Throwable
        ) {
            Log.d("riba", "아이템 상세 정보 실패 : $t")
        }
    })

}

public fun getBattleitemInfoDetailMulti(cyphersConnector: CyphersService, itemIdMulti: String){

    val callGetBattleitemInfoDetailMulti = cyphersConnector.getBattleitemInfoDetailMulti(itemIdMulti, BuildConfig.NeopleAPIKey)

    callGetBattleitemInfoDetailMulti.enqueue(object : Callback<ResponseBattleitemInfoDetailMulti> {
        override fun onResponse(
            call: Call<ResponseBattleitemInfoDetailMulti>,
            response: Response<ResponseBattleitemInfoDetailMulti>
        ) {
            Log.d("riba", "아이템 다중 상세 정보 성공 : ${response.raw()}")
            Log.d("riba", "아이템 다중 상세 정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseBattleitemInfoDetailMulti>,
            t: Throwable
        ) {
            Log.d("riba", "아이템 다중 상세 정보 실패 : $t")
        }
    })

}

public fun getCharacterInfo(cyphersConnector: CyphersService){
    val callGetCharacterInfo = cyphersConnector.getCharacterInfo(BuildConfig.NeopleAPIKey)


    callGetCharacterInfo.enqueue(object : Callback<ResponseCharacterInfo> {
        override fun onResponse(
            call: Call<ResponseCharacterInfo>,
            response: Response<ResponseCharacterInfo>
        ) {
            Log.d("riba", "캐릭터 정보 성공 : ${response.raw()}")
            Log.d("riba", "캐릭터 정보 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponseCharacterInfo>,
            t: Throwable
        ) {
            Log.d("riba", "캐릭터 정보 실패 : $t")
        }
    })
}

public  fun getPositionAttribute(cyphersConnector: CyphersService, positionCode : String){

    val callGetPositionAttribute = cyphersConnector.getPositionAttribute(positionCode,BuildConfig.NeopleAPIKey)

    callGetPositionAttribute.enqueue(object : Callback<ResponsePositionAttribute> {
        override fun onResponse(
            call: Call<ResponsePositionAttribute>,
            response: Response<ResponsePositionAttribute>
        ) {
            Log.d("riba", "포지션 특성 성공 : ${response.raw()}")
            Log.d("riba", "포지션 특성 내용물 : ${response.body()}")
        }

        override fun onFailure(
            call: Call<ResponsePositionAttribute>,
            t: Throwable
        ) {
            Log.d("riba", "포지션 특성 실패 : $t")
        }
    })

}