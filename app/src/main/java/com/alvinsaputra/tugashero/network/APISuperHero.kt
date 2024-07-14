package com.alvinsaputra.tugashero.network

import com.alvinsaputra.tugashero.model.SuperHero
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APISuperHero {
    @GET("{id}")
    fun getSuperHero(
        @Path("id") id: String
    ): Call<SuperHero>
}

//Alvin Saputra_10121063