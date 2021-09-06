package com.example.util.network.responsePlayerMatchingHistory

data class ResponsePlayerMatchingHistory(
    val clanName: String,
    val grade: Int,
    val matches: Matches,
    val maxRatingPoint: Int,
    val nickname: String,
    val playerId: String,
    val ratingPoint: Int,
    val records: List<Record>,
    val tierName: String
)
