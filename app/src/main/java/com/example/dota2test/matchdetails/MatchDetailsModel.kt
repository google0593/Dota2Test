package com.example.dota2test.matchdetails


import com.google.gson.annotations.SerializedName

data class MatchDetailsModel(
    @SerializedName("result")
    val result: Result
) {
    data class Result(
        @SerializedName("barracks_status_dire")
        val barracksStatusDire: Int,
        @SerializedName("barracks_status_radiant")
        val barracksStatusRadiant: Int,
        @SerializedName("cluster")
        val cluster: Int,
        @SerializedName("dire_score")
        val direScore: Int,
        @SerializedName("duration")
        val duration: Int,
        @SerializedName("engine")
        val engine: Int,
        @SerializedName("first_blood_time")
        val firstBloodTime: Int,
        @SerializedName("flags")
        val flags: Int,
        @SerializedName("game_mode")
        val gameMode: Int,
        @SerializedName("human_players")
        val humanPlayers: Int,
        @SerializedName("leagueid")
        val leagueid: Int,
        @SerializedName("lobby_type")
        val lobbyType: Int,
        @SerializedName("match_id")
        val matchId: Long,
        @SerializedName("match_seq_num")
        val matchSeqNum: Long,
        @SerializedName("negative_votes")
        val negativeVotes: Int,
        @SerializedName("picks_bans")
        val picksBans: List<PicksBan>,
        @SerializedName("players")
        val players: List<Player>,
        @SerializedName("positive_votes")
        val positiveVotes: Int,
        @SerializedName("pre_game_duration")
        val preGameDuration: Int,
        @SerializedName("radiant_score")
        val radiantScore: Int,
        @SerializedName("radiant_win")
        val radiantWin: Boolean,
        @SerializedName("start_time")
        val startTime: Int,
        @SerializedName("tower_status_dire")
        val towerStatusDire: Int,
        @SerializedName("tower_status_radiant")
        val towerStatusRadiant: Int
    ) {
        data class PicksBan(
            @SerializedName("hero_id")
            val heroId: Int,
            @SerializedName("is_pick")
            val isPick: Boolean,
            @SerializedName("order")
            val order: Int,
            @SerializedName("team")
            val team: Int
        )

        data class Player(
            @SerializedName("ability_upgrades")
            val abilityUpgrades: List<AbilityUpgrade>,
            @SerializedName("account_id")
            val accountId: Long,
            @SerializedName("assists")
            val assists: Int,
            @SerializedName("backpack_0")
            val backpack0: Int,
            @SerializedName("backpack_1")
            val backpack1: Int,
            @SerializedName("backpack_2")
            val backpack2: Int,
            @SerializedName("deaths")
            val deaths: Int,
            @SerializedName("denies")
            val denies: Int,
            @SerializedName("gold")
            val gold: Int,
            @SerializedName("gold_per_min")
            val goldPerMin: Int,
            @SerializedName("gold_spent")
            val goldSpent: Int,
            @SerializedName("hero_damage")
            val heroDamage: Int,
            @SerializedName("hero_healing")
            val heroHealing: Int,
            @SerializedName("hero_id")
            val heroId: Int,
            @SerializedName("item_0")
            val item0: Int,
            @SerializedName("item_1")
            val item1: Int,
            @SerializedName("item_2")
            val item2: Int,
            @SerializedName("item_3")
            val item3: Int,
            @SerializedName("item_4")
            val item4: Int,
            @SerializedName("item_5")
            val item5: Int,
            @SerializedName("item_neutral")
            val itemNeutral: Int,
            @SerializedName("kills")
            val kills: Int,
            @SerializedName("last_hits")
            val lastHits: Int,
            @SerializedName("leaver_status")
            val leaverStatus: Int,
            @SerializedName("level")
            val level: Int,
            @SerializedName("player_slot")
            val playerSlot: Int,
            @SerializedName("scaled_hero_damage")
            val scaledHeroDamage: Int,
            @SerializedName("scaled_hero_healing")
            val scaledHeroHealing: Int,
            @SerializedName("scaled_tower_damage")
            val scaledTowerDamage: Int,
            @SerializedName("tower_damage")
            val towerDamage: Int,
            @SerializedName("xp_per_min")
            val xpPerMin: Int
        ) {
            data class AbilityUpgrade(
                @SerializedName("ability")
                val ability: Int,
                @SerializedName("level")
                val level: Int,
                @SerializedName("time")
                val time: Int
            )
        }
    }
}