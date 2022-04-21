package com.meat.samplecleanarchitecture.presentation.home_detail

import com.meat.samplecleanarchitecture.domain.model.AllCoinsModel
import com.meat.samplecleanarchitecture.domain.model.CoinDetailModel

data class CoinDetailedState (
    val isLoading:Boolean= false,
    val coin: CoinDetailModel? = null,
    val error:String=""
        )

