package com.example.cyphers_matching_search_system.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cyphers_matching_search_system.playerSearch.PlayerSearchActivity
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.battleitemInfo.BattleitemInfoActivity

import com.example.util.network.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        playerInfoBtn.setOnClickListener{
            val playerSerchActivity = Intent(this, PlayerSearchActivity::class.java)
            startActivity(playerSerchActivity)
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
            val battleitemInfoActivity = Intent(this, BattleitemInfoActivity::class.java)
            startActivity(battleitemInfoActivity)
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