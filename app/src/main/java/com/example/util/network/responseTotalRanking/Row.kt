package com.example.util.network.responseTotalRanking

data class Row(
    val clanName: String,
    val grade: Int,
    val nickname: String,
    val playerId: String,
    val rank: Int,
    val ratingPoint: Int
)