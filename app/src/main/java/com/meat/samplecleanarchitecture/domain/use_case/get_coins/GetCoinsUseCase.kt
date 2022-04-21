package com.meat.samplecleanarchitecture.domain.use_case.get_coins

import com.meat.samplecleanarchitecture.common.Resource
import com.meat.samplecleanarchitecture.data.remote.dto.toAllCoinsModel
import com.meat.samplecleanarchitecture.domain.model.AllCoinsModel
import com.meat.samplecleanarchitecture.domain.model.CoinDetailModel
import com.meat.samplecleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository)  {

    operator fun invoke():Flow<Resource<List<AllCoinsModel>>>  = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toAllCoinsModel() }
            emit(Resource.Success<List<AllCoinsModel>>(coins))
        }catch (ex:HttpException){
            emit(Resource.Error<List<AllCoinsModel>>(ex.localizedMessage ?: "An unexpected error occured"))
        }
        //EXAMPLE IO EXCEPTION - no internet
        catch (ex:IOException){
            emit(Resource.Error<List<AllCoinsModel>>("Check internet connection"))
        }
    }
}