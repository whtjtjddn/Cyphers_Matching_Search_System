package com.example.util.network.responseMatchingInfo

data class ResponseMatchingInfo(
    val date: String,
    val gameTypeId: String,
    val map: Map,
    val players: List<Player>,
    val teams: List<Team>
)