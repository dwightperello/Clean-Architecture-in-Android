package com.meat.samplecleanarchitecture.presentation.home_list

import com.meat.samplecleanarchitecture.domain.model.AllCoinsModel

data class CoinListState(
    val isLoading:Boolean= false,
    val coins: List<AllCoinsModel> = emptyList(),
    val error:String=""
)
