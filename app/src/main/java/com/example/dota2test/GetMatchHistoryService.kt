package com.example.dota2test

import com.example.dota2test.dto.MatchHistoryList
import com.example.dota2test.userInfo.UserInfoList


import retrofit2.Call
import retrofit2.http.GET


interface GetMatchHistoryService {
    //User's Match History
    @GET("IDOTA2Match_570/GetMatchHistory/V001/?account_id=76561198024601086&key=98386B16E9E93CE3F216965CC303BEA5")
    fun getAllMatchHistory() : Call<MatchHistoryList>

    //User Info
    @GET("ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&steamids=76561198024601086")
    fun getUserInfo() : Call<UserInfoList>


}