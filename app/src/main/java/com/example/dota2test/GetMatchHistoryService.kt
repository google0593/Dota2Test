package com.example.dota2test


import com.example.dota2test.dto.MatchHistoryList
import com.example.dota2test.userInfo.UserInfoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface GetMatchHistoryService {
    //var steamID: String
    //User's Match History
    @GET("IDOTA2Match_570/GetMatchHistory/V001/?account_id=76561198024601086&key=98386B16E9E93CE3F216965CC303BEA5")
    fun getAllMatchHistory(): Call<MatchHistoryList>


    //User Info
    @GET("ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&steamids=76561198024601086")
    //@Url("ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&steamids=")
    fun getUserInfo(): Call<UserInfoList>

//    @GET("ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&")
//    fun getUsers(
//        @Query("steamIDS") vararg userId: MutableList<Long>
//    ): Call<UserInfoList?>?

    //    @GET("ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&")
//    fun getUsers(@QueryMap parameters: MutableMap<String?, Long?>?): Call<UserInfoList?>?
//    @GET("ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&")
    //fun getUsers(@Query("steamids") userId: Long): Call<UserInfoList>
 //   fun getUsers(@Query ("steamids" ) ids: ArrayList<Long>): Call<UserInfoList>
    @GET
    fun getUsers(@Url steamIDURL: String): Call<UserInfoList>


}