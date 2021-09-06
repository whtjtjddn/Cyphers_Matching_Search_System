package com.example.util.network.responsePlayerMatchingHistory

data class Matches(
    val date: Date,
    val gameTypeId: String,
    val next: String,
    val rows: List<Row>
)