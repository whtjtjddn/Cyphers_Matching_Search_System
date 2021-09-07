package com.example.util.network.responseBattleitemInfoDetail

data class ResponseBattleitemInfoDetail(
    val characterId: String,
    val characterName: String,
    val explain: String,
    val explainDetail: String,
    val itemId: String,
    val itemName: String,
    val rarityCode: String,
    val rarityName: String,
    val seasonCode: String,
    val seasonName: String,
    val slotCode: String,
    val slotName: String
)