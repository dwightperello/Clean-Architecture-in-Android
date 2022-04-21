package com.meat.samplecleanarchitecture.domain.model

import com.meat.samplecleanarchitecture.data.remote.dto.CoinsDetailsDto
import com.meat.samplecleanarchitecture.data.remote.dto.TeamMember

data class CoinDetailModel(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val description: String,
    val tags: List<String>,
    val team: List<TeamMember>

)
