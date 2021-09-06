package com.example.util.network.responseCharacterRanking

data class Row(
    val clanName: String,
    val grade: Int,
    val loseCount: Int,
    val nickname: String,
    val playerId: String,
    val rank: Int,
    val winCount: Int
)