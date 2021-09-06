package com.example.util.network.responsePlayerInfoDetail

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