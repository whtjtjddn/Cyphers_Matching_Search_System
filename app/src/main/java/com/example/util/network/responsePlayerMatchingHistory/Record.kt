package com.example.util.network.responsePlayerMatchingHistory

data class Record(
    val gameTypeId: String,
    val loseCount: Int,
    val stopCount: Int,
    val winCount: Int
)
