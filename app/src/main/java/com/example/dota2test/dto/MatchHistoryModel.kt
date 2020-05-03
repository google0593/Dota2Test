package com.example.dota2test.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MatchHistoryModel(
    @SerializedName("result")
    val result: Result
    //val match: Result.Matches,
    //val player: Result.Matches.Player
) {
    data class Result(
        @SerializedName("matches")
        val matches: List<Matches>,
        val num_results: Int,
        val results_remaining: Int,
        val status: Int,
        val total_results: Int
    ) {
        data class Matches(
            val dire_team_id: Int,
            val lobby_type: Int,
            val match_id: Long,
            val match_seq_num: Long,
            @SerializedName("players")
            @Expose
            val players: List<Player>,
            val radiant_team_id: Int,
            val start_time: Int

        ) {
            data class Player(
                @SerializedName("account_id")
                var account_id: Long,
                val hero_id: Int,
                val player_slot: Int
            )
        }
    }

}
