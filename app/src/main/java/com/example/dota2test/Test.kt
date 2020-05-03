package com.example.dota2test

import android.view.View
import android.widget.TextView
import com.example.dota2test.dto.MatchHistoryModel
import com.example.dota2test.userInfo.UserInfoList
import com.example.dota2test.userInfo.UserInfoModel
import kotlinx.android.synthetic.main.match_history.view.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Test {
    val service =
        RetrofitClientInstance.retrofitInstance?.create(GetMatchHistoryService::class.java)
    var playerData: List<UserInfoModel.Response.Player> = ArrayList()
    val adapter = DotaMatchHistoryAdapter()

    /**
     *Reference for this code: https://stackoverflow.com/questions/38092895/retrofit-query-annotation-without-ampersand
     */
    /**
     * Todo
     *
     *  */
    fun getUserInfo(v: View, item: MatchHistoryModel.Result.Matches) {

        var steamID64: Long
        val steamIDs = mutableListOf<Long>()
        var steamIDUrl = ""
        val steamGetPlayerSummariesCall =
            "ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&"


        for (player in item.players) {
            if (player.account_id == 4294967295) {
                steamIDs.add(76561198106149037)
            } else {
                steamID64 = (player.account_id + 76561197960265728)
                steamIDs.add(steamID64)
            }
        }

        for (steamID in steamIDs) {
            steamIDUrl += "steamids=$steamID"
        }


        val call3 = service?.getUsers(steamGetPlayerSummariesCall + steamIDUrl)
        call3?.enqueue(object : Callback<UserInfoList> {
            override fun onFailure(call: Call<UserInfoList>, t: Throwable) {
                println("Failed to parse userInfo because ${t.fillInStackTrace()}")
            }

            override fun onResponse(
                call: Call<UserInfoList>,
                response: Response<UserInfoList>
            ) {
                println("Parse OK link:${response.raw().request().url()}")
                println("Parse OK: getSteamNames$" + response.body())
                val result2: List<UserInfoModel.Response.Player> =
                    response.body()?.response!!.players

                v.playerOne.text = result2[0].personaname
                v.playerTwo.text = result2[1].personaname
                v.playerThree.text = result2[2].personaname
                v.playerFour.text = result2[3].personaname
                v.playerFive.text = result2[4].personaname
                v.playerSix.text = result2[5].personaname
                v.playerSeven.text = result2[6].personaname
                v.playerEight.text = result2[7].personaname
                v.playerNine.text = result2[8].personaname
                v.playerTen.text = result2[9].personaname
            }
        })

    }


}