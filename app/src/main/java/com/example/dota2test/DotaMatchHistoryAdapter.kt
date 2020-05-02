package com.example.dota2test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2test.Test.getSteamNames
import com.example.dota2test.dto.MatchHistoryModel
import com.example.dota2test.userInfo.UserInfoModel
import kotlinx.android.synthetic.main.match_history.view.*

class DotaMatchHistoryAdapter() : RecyclerView.Adapter<DotaMatchHistoryAdapter.ViewHolder>() {

    private var data: List<MatchHistoryModel.Result.Matches> = ArrayList()
    var playerData: List<UserInfoModel.Response.Player> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.match_history, parent, false)
        )
    }

    override fun getItemCount() = data.size

    //    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
//        holder.itemView.playerOne.text = playerData[0].personaname


    }

    fun swapData(data: List<MatchHistoryModel.Result.Matches>) {
        this.data = data

        notifyDataSetChanged()
    }


//    fun getPlayersInfo(playerData: List<UserInfoModel.Response.Player>) {
//        this.playerData = playerData
//        println("getPlayersInfo this:" + this.playerData)
//        println("getPlayersInfo:" + playerData)
//
//        //notifyDataSetChanged()
//    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: MatchHistoryModel.Result.Matches) = with(itemView) {
            var steamID64: String
            val steamIDs = mutableListOf<Long>()




            matchNumberView.text = item.match_id.toString()
            for ((index, player) in item.players.withIndex()) {

                /**
                 *convert 32 Bit steam id to 64 bit steam id
                 *formula 76561197960265728 + 32 Steam ID
                 **/
                if (player.account_id == 4294967295) {
                    steamID64 = 11111111.toString()

                } else {
                    steamID64 = (76561197960265728 + player.account_id).toString()
                }
                when (index) {
                    0 -> {
                        playerOne.text = steamID64
                    }
                    1 -> {
                        playerTwo.text = steamID64
                    }
                    2 -> {
                        playerThree.text = steamID64
                    }
                    3 -> {
                        playerFour.text = steamID64
                    }
                    4 -> {
                        playerFive.text = steamID64
                    }
                    5 -> {
                        playerSix.text = steamID64
                    }
                    6 -> {
                        playerSeven.text = steamID64
                    }
                    7 -> {
                        playerEight.text = steamID64
                    }
                    8 -> {
                        playerNine.text = steamID64
                    }
                    9 -> {
                        playerTen.text = steamID64
                    }
                }

            }

            // TODO: Bind the data with View
            setOnClickListener {


//                println(playerOne.text)
//                Toast.makeText(context, playerOne.text, Toast.LENGTH_SHORT).show()
                val a = item.players
                for (players in a) {
                    if (players.account_id == 4294967295) {
                        //if player is anonymous
                        steamIDs.add(76561198106149037)
                    } else {
                        steamIDs.add((players.account_id + 76561197960265728))
                    }
                }
                println("Steam IDS list:  $steamIDs")
                getSteamNames(steamIDs as ArrayList<Long>)
                steamIDs.clear()
            }

        }

    }

}

