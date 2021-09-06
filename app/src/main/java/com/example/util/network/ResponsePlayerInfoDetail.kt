package com.example.util.network

data class ResponsePlayerInfoDetail(
    val clanName: String,
    val grade: Int,
    val maxRatingPoint: Int,
    val nickname: String,
    val playerId: String,
    val ratingPoint: Int,
    val records: List<Record>,
    val tierName: String
)

data class Record(
        val gameTypeId: String,
        val loseCount: Int,
        val stopCount: Int,
        val winCount: Int
)