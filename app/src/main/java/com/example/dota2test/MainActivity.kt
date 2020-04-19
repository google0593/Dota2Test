package com.example.dota2test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2test.dto.MatchHistoryList
import com.example.dota2test.dto.MatchHistoryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    /**
     * Dota 2 API KEY = 98386B16E9E93CE3F216965CC303BEA5
     * My personal steam id = 64335358
     * Personal match history = https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/?account_id=64335358&key=98386B16E9E93CE3F216965CC303BEA5
     * https://www.youtube.com/watch?v=53BsyxwSBJk&t=1106s tutorial
     * */

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DotaMatchHistoryAdapter
    var dataList = ArrayList<MatchHistoryModel.Result.Matches>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerView = findViewById(R.id.matchHistoryRecylerView)
        //setting up the adapter
        //recyclerView.adapter= DotaMatchHistoryAdapter(dataList,this)
        //recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView = findViewById(R.id.matchHistoryRecylerView)
        adapter = DotaMatchHistoryAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter


        val service =
            RetrofitClientInstance.retrofitInstance?.create(GetMatchHistoryService::class.java)
        val call = service?.getAllMatchHistory()
        call?.enqueue(object : Callback<MatchHistoryList> {
            override fun onFailure(call: Call<MatchHistoryList>, t: Throwable) {
                println("Failed to parse because ${t.fillInStackTrace()}")

            }

            override fun onResponse(
                call: Call<MatchHistoryList>, response: Response<MatchHistoryList>
            ) {
                println("Parse OK")
                //val result1: List<MatchHistoryModel.Result.Matches> = response?.body()?.result?.result!!.matches
                val result1: List<MatchHistoryModel.Result.Matches> = response.body()?.result!!.matches
                //val result2 = response?.body()?.result?.matches!![4].players[4].account_id
                // val result3: List<MatchHistoryModel.Result.Matches.Player> = response?.body()?.matchesa!!.players
                //var data: List<> = ArrayList()
                val responseBody = response.body()

                //dataList = response?.body()?.result!!.matches as ArrayList<MatchHistoryModel.Result.Matches>
                //println(response.body()!!.resultb)
                adapter.swapData(result1)

            }
        })


    }


}
