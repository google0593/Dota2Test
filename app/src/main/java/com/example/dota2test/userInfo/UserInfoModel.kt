package com.example.dota2test.userInfo


import com.google.gson.annotations.SerializedName

data class UserInfoModel(
    @SerializedName("response")
    val response: Response
) {
    data class Response(
        @SerializedName("players")
        val players: List<Player>
    ) {
        data class Player(
            @SerializedName("avatar")
            val avatar: String,
            @SerializedName("avatarfull")
            val avatarfull: String,
            @SerializedName("avatarmedium")
            val avatarmedium: String,
            @SerializedName("communityvisibilitystate")
            val communityvisibilitystate: Int,
            @SerializedName("loccityid")
            val loccityid: Int,
            @SerializedName("loccountrycode")
            val loccountrycode: String,
            @SerializedName("locstatecode")
            val locstatecode: String,
            @SerializedName("personaname")
            val personaname: String,
            @SerializedName("personastate")
            val personastate: Int,
            @SerializedName("personastateflags")
            val personastateflags: Int,
            @SerializedName("primaryclanid")
            val primaryclanid: String,
            @SerializedName("profilestate")
            val profilestate: Int,
            @SerializedName("profileurl")
            val profileurl: String,
            @SerializedName("realname")
            val realname: String,
            @SerializedName("steamid")
            val steamid: String,
            @SerializedName("timecreated")
            val timecreated: Int
        )
    }
}