package com.example.util.network

data class ResponsePlayerInfo(
    val rows: List<Row>
)

data class Row(
        val grade: Int,
        val nickname: String,
        val playerId: String
)