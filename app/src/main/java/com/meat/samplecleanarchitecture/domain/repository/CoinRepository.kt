package com.meat.samplecleanarchitecture.domain.repository

import com.meat.samplecleanarchitecture.data.remote.dto.AllCoinsDto
import com.meat.samplecleanarchitecture.data.remote.dto.CoinsDetailsDto

interface CoinRepository {

    suspend fun getCoins():List<AllCoinsDto>

    suspend fun getCoinById( coinId:String):CoinsDetailsDto
}