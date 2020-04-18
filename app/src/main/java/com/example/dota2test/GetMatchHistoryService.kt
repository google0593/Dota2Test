package com.example.dota2test

import com.example.dota2test.dto.MatchHistoryList


import retrofit2.Call
import retrofit2.http.GET


interface GetMatchHistoryService {

    @GET("IDOTA2Match_570/GetMatchHistory/V001/?account_id=64335358&key=98386B16E9E93CE3F216965CC303BEA5")
    fun getAllMatchHistory() : Call<MatchHistoryList>
//    fun getAllMatchHistory() : Call<List<MatchHistoryList>>


}