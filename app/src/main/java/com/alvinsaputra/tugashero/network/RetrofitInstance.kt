package com.alvinsaputra.tugashero.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://superheroapi.com/api/b4393ad2c26813ff8c16a992e02aabc3/"

    val api: APISuperHero by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APISuperHero::class.java)
    }
}

//Alvin Saputra_10121063