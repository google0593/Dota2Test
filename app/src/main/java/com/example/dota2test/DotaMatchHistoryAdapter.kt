package com.example.dota2test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2test.Test.getUserInfo
import com.example.dota2test.dto.MatchHistoryModel
import com.example.dota2test.userInfo.UserInfoModel
import kotlinx.android.synthetic.main.match_history.view.*


class DotaMatchHistoryAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: List<MatchHistoryModel.Result.Matches> = ArrayList()
    var playerData: List<UserInfoModel.Response.Player> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return when (viewType) {
            0 -> MatchHistoryViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.match_history, parent, false)
            )
            1 -> PlayerInfoViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.player_details, parent, false)
            )
            else -> MatchHistoryViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.match_history, parent, false)
            )
        }
    }


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.match_history, parent, false)
//        )
//    }

    override fun getItemCount() = data.size

    //    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        MatchHistoryViewHolder(holder.itemView).matchHistoryViewHolder(data[position])
        println("onbind" + playerData.size)

    }

    fun swapData(data: List<MatchHistoryModel.Result.Matches>) {
        this.data = data
        notifyDataSetChanged()
    }


    class MatchHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val steamGetPlayerSummariesCall = "ISteamUser/GetPlayerSummaries/v0002/?key=98386B16E9E93CE3F216965CC303BEA5&"

        fun matchHistoryViewHolder(item: MatchHistoryModel.Result.Matches) = with(itemView) {

            matchNumberView.text = item.match_id.toString()

            matchNumberView.text = item.match_id.toString()

            for ((index, player) in item.players.withIndex()) {

                /**
                 *convert 32 Bit steam id to 64 bit steam id
                 *formula 76561197960265728 + 32 Steam ID
                 **/
                val steamID64:String = if (player.account_id == 4294967295) {
                    "Anonymous"
                } else {
                    (76561197960265728 + player.account_id).toString()
                }

                when (index) {
                    0 -> playerOne.text = steamID64
                    1 -> playerTwo.text = steamID64
                    2 -> playerThree.text = steamID64
                    3 -> playerFour.text = steamID64
                    4 -> playerFive.text = steamID64
                    5 -> playerSix.text = steamID64
                    6 -> playerSeven.text = steamID64
                    7 -> playerEight.text = steamID64
                    8 -> playerNine.text = steamID64
                    9 -> playerTen.text = steamID64
                }
            }

            setOnClickListener {
                getUserInfo(it,item)
            }
        }

    }

    class PlayerInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var steamID64: String
        val steamIDs = mutableListOf<Long>()
        fun playerInfoViewHolder(item: UserInfoModel.Response.Player) = with(itemView) {


            setOnClickListener {


            }
        }
    }

}

