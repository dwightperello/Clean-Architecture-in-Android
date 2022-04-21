package com.meat.samplecleanarchitecture.data.remote.dto


import androidx.annotation.Keep
import com.meat.samplecleanarchitecture.domain.model.CoinDetailModel

@Keep
data class CoinsDetailsDto(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val is_new: Boolean,
    val is_active: Boolean,
    val type: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val description: String,
    val message: String,
    val open_source: Boolean,
    val started_at: String,
    val development_status: String,
    val hardware_wallet: Boolean,
    val proof_type: String,
    val org_structure: String,
    val hash_algorithm: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val whitepaper: Whitepaper,
    val first_data_at: String,
    val last_data_at: String
) {
    @Keep
    data class Tag(
        val id: String,
        val name: String,
        val coin_counter: Int,
        val ico_counter: Int
    )

    @Keep
    data class Team(
        val id: String,
        val name: String,
        val position: String
    )

    @Keep
    data class Links(
        val explorer: List<String>,
        val facebook: List<String>,
        val reddit: List<String>,
        val source_code: List<String>,
        val website: List<String>,
        val youtube: List<String>
    )

    @Keep
    data class LinksExtended(
        val url: String,
        val type: String,
        val stats: Stats
    ) {
        @Keep
        data class Stats(
            val subscribers: Int,
            val contributors: Int,
            val stars: Int,
            val followers: Int
        )
    }

    @Keep
    data class Whitepaper(
        val link: String,
        val thumbnail: String
    )
}

fun CoinsDetailsDto.toCoinDetailModel(): CoinDetailModel{
    return CoinDetailModel(
        id=id,
        name=name,
        symbol=symbol,
        rank=rank,
        is_active=is_active,
        description=description,
        tags = tags.map { it.name },
        team=team
    )
}