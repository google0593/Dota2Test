package com.example.dota2test

import android.graphics.*
import android.view.View
import com.example.dota2test.dto.MatchHistoryModel
import com.example.dota2test.userInfo.UserInfoList
import com.example.dota2test.userInfo.UserInfoModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import kotlinx.android.synthetic.main.match_history.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object Test {
    private val service =
        RetrofitClientInstance.retrofitInstance?.create(GetMatchHistoryService::class.java)


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
            steamIDUrl += "steamIds=$steamID"
        }


        val call = service?.getUsers(steamGetPlayerSummariesCall + steamIDUrl)
        call?.enqueue(object : Callback<UserInfoList> {
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
                Picasso.get().load(result2[0].avatarfull).into(v.playerOneImg)

                v.playerTwo.text = result2[1].personaname
                Picasso.get().load(result2[1].avatarfull).into(v.playerTwoImg)

                v.playerThree.text = result2[2].personaname
                Picasso.get().load(result2[2].avatarfull).into(v.playerThreeImg)

                v.playerFour.text = result2[3].personaname
                Picasso.get().load(result2[3].avatarfull).into(v.playerFourImg)

                v.playerFive.text = result2[4].personaname
                Picasso.get().load(result2[4].avatarfull).into(v.playerFiveImg)

                v.playerSix.text = result2[5].personaname
                Picasso.get().load(result2[5].avatarfull).into(v.playerSixImg)

                v.playerSeven.text = result2[6].personaname
                Picasso.get().load(result2[6].avatarfull).into(v.playerSevenImg)

                v.playerEight.text = result2[7].personaname
                Picasso.get().load(result2[7].avatarfull).into(v.playerEightImg)

                v.playerNine.text = result2[8].personaname
                Picasso.get().load(result2[8].avatarfull).into(v.playerNineImg)

                v.playerTen.text = result2[9].personaname
                Picasso.get().load(result2[9].avatarfull).into(v.playerTenImg)
            }
        })

    }

    fun getMatchDetails(matchID: String){
        val steamGetPlayerSummariesCall =
            "IDOTA2Match_570/GetMatchDetails/V001/?key=98386B16E9E93CE3F216965CC303BEA5&"
        val call3 = service?.getUsers(steamGetPlayerSummariesCall + matchID)
        call3?.enqueue(object : Callback<UserInfoList> {
            override fun onFailure(call: Call<UserInfoList>, t: Throwable) {
                println("Failed to parse userInfo because ${t.fillInStackTrace()}")
            }

            override fun onResponse(call: Call<UserInfoList>, response: Response<UserInfoList>) {
                println("Parse OK link:${response.raw().request().url()}")
                println("Parse OK: getMatchDetails$" + response.body())
                val result2: List<UserInfoModel.Response.Player> =
                    response.body()?.response!!.players


            }
        })
    }

    class CircleTransform : Transformation {
        override fun transform(source: Bitmap): Bitmap {
            val size = Math.min(source.width, source.height)
            val x = (source.width - size) / 2
            val y = (source.height - size) / 2
            val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
            if (squaredBitmap != source) {
                source.recycle()
            }
            val bitmap = Bitmap.createBitmap(size, size, source.config)
            val canvas = Canvas(bitmap)
            val paint = Paint()
            val shader = BitmapShader(
                squaredBitmap,
                Shader.TileMode.CLAMP, Shader.TileMode.CLAMP
            )
            paint.shader = shader
            paint.isAntiAlias = true
            val r = size / 2f
            canvas.drawCircle(r, r, r, paint)
            squaredBitmap.recycle()
            return bitmap
        }

        override fun key(): String {
            return "circle"
        }
    }

}