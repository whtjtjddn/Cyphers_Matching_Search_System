package com.example.cyphers_matching_search_system

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

import com.example.util.network.*
import com.example.util.network.responsePlayerInfo.ResponsePlayerInfo
import com.example.util.network.responsePlayerMatchingHistory.ResponsePlayerMatchingHistory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val player_info_intent = Intent(this, MainActivity2::class.java)

        val cyphersConnector = getCyphersConnector()

        //TODO 동작 확인용 임시 데이터
        val playerNickname = "리바리바리바"
        val playerId = "e852fa7278e9e3eeea97bd3775dcd287"
        val matchId = "9380a5e4267db146c49f71bb123096ee214eabae92b5c868e554b7374431e18b"
        val characterId = "d69971a6762d94340bb2332e8735238a" //휴톤
        val itemName = "트리플 버스터"
        val itemId = "777e72f2cd35f2f3e3d7788abb375738"
        val itemId2 = "7d60f99dc8719456d531c5016217ad95"
        val positionCode = "678bca255e575ae96aceefacaa7aee4e"
        val wordType = null
        val limit = null

        val playerInfoBtn = findViewById<View>(R.id.PlayerInfoBtn)
        val playerInfoDetailBtn = findViewById<View>(R.id.PlayerInfoDetailBtn)
        val playerMatchingHistoryBtn = findViewById<View>(R.id.PlayerMatchingHistoryBtn)
        val matchingInfoBtn = findViewById<View>(R.id.MatchingInfoBtn)
        val totalRankingBtn = findViewById<View>(R.id.TotalRankingBtn)
        val CharacterRankingBtn = findViewById<View>(R.id.CharacterRankingBtn)
        val TSJRankingBtn = findViewById<View>(R.id.TSJRankingBtn)
        val BattleitemInfoBtn = findViewById<View>(R.id.BattleitemInfoBtn)
        val BattleitemInfoDetailBtn = findViewById<View>(R.id.BattleitemInfoDetailBtn)
        val BattleitemInfoDetailMultiBtn = findViewById<View>(R.id.BattleitemInfoDetailMultiBtn)
        val CharacterInfoBtn = findViewById<View>(R.id.CharacterInfoBtn)
        val PositionAttributeBtn = findViewById<View>(R.id.PositionAttributeBtn)
        val testing = findViewById<View>(R.id.test_text) as TextView

        playerInfoBtn.setOnClickListener{
            val callGetPlayerMatchingHistory = cyphersConnector.getPlayerMatchingHistory(playerId, BuildConfig.NeopleAPIKey)

            callGetPlayerMatchingHistory.enqueue(object : Callback<ResponsePlayerMatchingHistory> {
                override fun onResponse(
                    call: Call<ResponsePlayerMatchingHistory>,
                    response: Response<ResponsePlayerMatchingHistory>
                ) {
                    response.body()?.let{
                        val nickname = it.nickname
                        player_info_intent.putExtra("player_Info",nickname.toString())
                    }


                    startActivity(player_info_intent)
                }

                override fun onFailure(
                    call: Call<ResponsePlayerMatchingHistory>,
                    t: Throwable
                ) {
                    Log.d("riba", "플레이어 매칭정보 실패 : $t")
                }
            })
            //getPlayerInfo(cyphersConnector, playerNickname)
        }
        playerInfoDetailBtn.setOnClickListener{
            getPlayerInfoDetail(cyphersConnector, playerId)
        }
        playerMatchingHistoryBtn.setOnClickListener{
            getPlayerMatchingHistory(cyphersConnector, playerId)
        }
        matchingInfoBtn.setOnClickListener{
            getMatchingInfo(cyphersConnector, matchId)
        }
        totalRankingBtn.setOnClickListener{
            getTotalRanking(cyphersConnector)
        }
        CharacterRankingBtn.setOnClickListener{
            getCharacterRanking(cyphersConnector, characterId)
        }
        TSJRankingBtn.setOnClickListener{
            getTSJRanking(cyphersConnector)
        }
        BattleitemInfoBtn.setOnClickListener{
            getBattleitemInfo(cyphersConnector, itemName)
        }
        BattleitemInfoDetailBtn.setOnClickListener{
            getBattleitemInfoDetail(cyphersConnector, itemId)
        }
        BattleitemInfoDetailMultiBtn.setOnClickListener{
            getBattleitemInfoDetailMulti(cyphersConnector, "$itemId,$itemId2")
        }
        CharacterInfoBtn.setOnClickListener{
            getCharacterInfo(cyphersConnector)
        }
        PositionAttributeBtn.setOnClickListener{
            getPositionAttribute(cyphersConnector, positionCode)
        }

    }

    companion object {
        @JvmField
        var taskUrl: String? = null
    }
}