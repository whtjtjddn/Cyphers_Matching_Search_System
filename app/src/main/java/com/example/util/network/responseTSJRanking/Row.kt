package com.example.util.network.responseTSJRanking

data class Row(
    val loseCount: Int,
    val nickname: String,
    val playerId: String,
    val rank: Int,
    val ratingPoint: Int,
    val winCount: Int,
    val winningStreak: Int
)