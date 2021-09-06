package com.example.util.network.responsePlayerMatchingHistory

data class Row(
    val date: String,
    val map: Map,
    val matchId: String,
    val playInfo: PlayInfo,
    val position: Position
)