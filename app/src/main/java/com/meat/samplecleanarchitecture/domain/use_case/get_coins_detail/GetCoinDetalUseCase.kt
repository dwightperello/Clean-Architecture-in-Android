package com.meat.samplecleanarchitecture.domain.use_case.get_coins_detail

import com.meat.samplecleanarchitecture.common.Resource
import com.meat.samplecleanarchitecture.data.remote.dto.toAllCoinsModel
import com.meat.samplecleanarchitecture.data.remote.dto.toCoinDetailModel
import com.meat.samplecleanarchitecture.domain.model.AllCoinsModel
import com.meat.samplecleanarchitecture.domain.model.CoinDetailModel
import com.meat.samplecleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetalUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetailModel>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetailModel()
            emit(Resource.Success<CoinDetailModel>(coin))
        }catch (ex: HttpException){
            emit(Resource.Error<CoinDetailModel>(ex.localizedMessage ?: "An unexpected error occured"))
        }
        //EXAMPLE IO EXCEPTION - no internet
        catch (ex: IOException){
            emit(Resource.Error<CoinDetailModel>("Check internet connection"))
        }
    }
}