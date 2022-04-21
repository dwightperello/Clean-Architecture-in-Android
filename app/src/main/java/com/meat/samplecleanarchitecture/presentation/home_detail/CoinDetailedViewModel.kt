package com.meat.samplecleanarchitecture.presentation.home_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meat.samplecleanarchitecture.common.Constants
import com.meat.samplecleanarchitecture.common.Resource

import com.meat.samplecleanarchitecture.domain.use_case.get_coins_detail.GetCoinDetalUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailedViewModel @Inject constructor(
    private val getDetailedCoinUseCase: GetCoinDetalUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(CoinDetailedState())
    val state: State<CoinDetailedState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getDetailedCoin(coinId)
        }
    }

    private fun getDetailedCoin(coinId:String){
        getDetailedCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _state.value = CoinDetailedState(coin = result.data)
                }
                is Resource.Error ->{
                    _state.value = CoinDetailedState(error = result.message ?: "Unexpected error")
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailedState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}