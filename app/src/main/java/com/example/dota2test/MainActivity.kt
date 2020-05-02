package com.example.dota2test

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2test.dto.MatchHistoryList
import com.example.dota2test.dto.MatchHistoryModel
import com.example.dota2test.userInfo.UserInfoList
import com.example.dota2test.userInfo.UserInfoModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    /**
     * Dota 2 API KEY = 98386B16E9E93CE3F216965CC303BEA5
     * My personal steam id = 76561198024601086
     * Personal match history = https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/?account_id=76561198024601086&key=98386B16E9E93CE3F216965CC303BEA5
     * https://www.youtube.com/watch?v=53BsyxwSBJk&t=1106s tutorial
     * */

    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: DotaMatchHistoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service =
            RetrofitClientInstance.retrofitInstance?.create(GetMatchHistoryService::class.java)



        recyclerView = findViewById(R.id.matchHistoryRecylerView)
        adapter = DotaMatchHistoryAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Padding set to 8dp
        recyclerView.addItemDecoration(
            MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt()
            )
        )
        recyclerView.adapter = adapter






        /**
         * Match History
         * */

        val call = service?.getAllMatchHistory()
        call?.enqueue(object : Callback<MatchHistoryList> {
            override fun onFailure(call: Call<MatchHistoryList>, t: Throwable) {
                println("Failed to parse because ${t.fillInStackTrace()}")

            }

            override fun onResponse(
                call: Call<MatchHistoryList>,
                response: Response<MatchHistoryList>
            ) {
                println("Parse OK")
                val result1: List<MatchHistoryModel.Result.Matches> =
                    response.body()?.result!!.matches
                val responseBody = response.body()
                //println(result1)

                adapter.swapData(result1)

            }
        })

        /**
         * User details
         * */


        val call2 = service?.getUserInfo()
        call2?.enqueue(object : Callback<UserInfoList> {
            override fun onFailure(call: Call<UserInfoList>, t: Throwable) {
                println("Failed to parse userinfo because ${t.fillInStackTrace()}")
            }

            override fun onResponse(call: Call<UserInfoList>, response: Response<UserInfoList>) {
                println("Parse OK")

                val userInfoResponse = response.body()?.response!!.players[0].personaname
                personNameView.text = response.body()?.response!!.players[0].personaname
                val imgURL = response.body()?.response!!.players[0].avatarfull
                Picasso.get().load(imgURL).into(userAvatarImg);
            }
        })

        /**
         * Match History Player Info
         * */

//        val call3 = service?.getUsers(geeks)
//        call3?.enqueue(object : Callback<UserInfoList?> {
//            override fun onFailure(call: Call<UserInfoList?>, t: Throwable) {
//                println("Failed to parse userinfo because ${t.fillInStackTrace()}")
//            }
//
//            override fun onResponse(call: Call<UserInfoList?>, response: Response<UserInfoList?>) {
//                println("Parse OK")
//
//                val userInfoResponse = response.body()
//                //personNameView.text = response.body()?.response!!.players[0].personaname
//                //val imgURL = response.body()?.response!!.players[0].avatarfull
//                //Picasso.get().load(imgURL).into(userAvatarImg);
//            }
//        })

    }

    class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View,
            parent: RecyclerView, state: RecyclerView.State
        ) {
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceHeight
                }
                left = spaceHeight
                right = spaceHeight
                bottom = spaceHeight
            }
        }
    }

}
