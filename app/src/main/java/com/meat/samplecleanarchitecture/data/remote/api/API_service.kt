package com.meat.samplecleanarchitecture.data.remote.api

import com.meat.samplecleanarchitecture.data.remote.dto.AllCoinsDto
import com.meat.samplecleanarchitecture.data.remote.dto.CoinsDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface API_service {

    @GET("/v1/coins")
    suspend fun getCoins() : List<AllCoinsDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getDetailedCoin(@Path("coinId")coinId:String) : CoinsDetailsDto
}