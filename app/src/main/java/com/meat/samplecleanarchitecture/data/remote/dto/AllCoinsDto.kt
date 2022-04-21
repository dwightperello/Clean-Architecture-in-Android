package com.meat.samplecleanarchitecture.data.remote.dto


import androidx.annotation.Keep
import com.meat.samplecleanarchitecture.domain.model.AllCoinsModel

@Keep
data class AllCoinsDto(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val is_new: Boolean,
    val is_active: Boolean,
    val type: String
)

fun AllCoinsDto.toAllCoinsModel():AllCoinsModel{
    return AllCoinsModel(
        id=id,
        name=name,
        symbol= symbol,
        rank= rank,
        is_active= is_active,

    )
}