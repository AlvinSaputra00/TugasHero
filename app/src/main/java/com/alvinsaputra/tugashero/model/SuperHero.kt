package com.alvinsaputra.tugashero.model

data class SuperHero(
    val id: String,
    val name: String,
    val biography: Biography,
    val powerstats: PowerStats,
    val image: Image
)

data class Biography(
    val fullName: String,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

//Alvin Saputra_10121063

data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)

data class Image(
    val url: String
)
