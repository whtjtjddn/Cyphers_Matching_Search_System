package com.example.util.network.responseMatchingInfo

data class Player(
    val items: List<Item>,
    val map: Map,
    val nickname: String,
    val playInfo: PlayInfo,
    val playerId: String,
    val position: Position
)