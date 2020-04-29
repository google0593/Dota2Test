package com.example.dota2test

import com.example.dota2test.userInfo.UserInfoList
import com.example.dota2test.userInfo.UserInfoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Test {
    private val service = RetrofitClientInstance.retrofitInstance?.create(GetMatchHistoryService::class.java)


    /**
     *Reference for this code: https://stackoverflow.com/questions/38092895/retrofit-query-annotation-without-ampersand
     */

    private const val steamGetPlayerSummariesCall = "ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&"

    val ab1 = ArrayList<Long>()
    fun getSteamNames(ab: ArrayList<Long>) {
        var steamIDUrl = ""

        for (steamID in ab) {
            steamIDUrl += "steamids=$steamID"
        }
        println("onResponse AB1: $ab")

        ab1

        val call3 = service?.getUsers(steamGetPlayerSummariesCall + steamIDUrl)
        call3?.enqueue(object : Callback<UserInfoList> {
            override fun onFailure(call: Call<UserInfoList>, t: Throwable) {
                println("Failed to parse userinfo because ${t.fillInStackTrace()}")
            }
            override fun onResponse(call: Call<UserInfoList>, response: Response<UserInfoList>) {
                println("Parse OK: getSteamNames")
                val result2: List<UserInfoModel.Response.Player> = response.body()?.response!!.players
//                println("onResponse first index: ${result2[0].personaname}")
//                println("onResponse second index: ${result2[1].personaname}")
//                println("onResponse third index: ${result2[2].personaname}")

                for(players in result2){
                    println("onResponse result2: "+ players.personaname)
                }

                for(players in response.body()!!.response.players){
                    println("onResponse response.body(): "+ players.personaname)
                }

                println("onResponse response: ${response.body()}")
                println("onResponse response size:${response.body()!!.response.players.size} onResponse result2 size:${result2.size}")
                println("onResponse link:${response.raw().request().url()}")

            }
        })
    }
}