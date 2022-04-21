package com.meat.samplecleanarchitecture.domain.model

data class AllCoinsModel(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,

)
