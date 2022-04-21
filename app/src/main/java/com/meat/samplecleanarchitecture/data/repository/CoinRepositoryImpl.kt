package com.meat.samplecleanarchitecture.data.repository

import com.meat.samplecleanarchitecture.data.remote.api.API_service
import com.meat.samplecleanarchitecture.data.remote.dto.AllCoinsDto
import com.meat.samplecleanarchitecture.data.remote.dto.CoinsDetailsDto
import com.meat.samplecleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl  @Inject constructor(private val api:API_service) :CoinRepository {
    override suspend fun getCoins(): List<AllCoinsDto> {
      return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinsDetailsDto {
        return api.getDetailedCoin(coinId)
    }
}