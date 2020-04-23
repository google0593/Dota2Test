package com.example.dota2test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2test.dto.MatchHistoryModel
import kotlinx.android.synthetic.main.match_history.view.*

class DotaMatchHistoryAdapter() : RecyclerView.Adapter<DotaMatchHistoryAdapter.ViewHolder>() {
    //var data: List<MatchHistoryList> = ArrayList()
    //var dataPlayer: List<MatchHistoryModel.Result.Matches.Player> = ArrayList()
    var data: List<MatchHistoryModel.Result.Matches> = ArrayList()

    private val listItems: ArrayList<MatchHistoryModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.match_history, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
//    override fun onBindViewHolder(holder: ViewHolder, position: Int){
//        holder.itemView.testView.text = data[position].match_id.toString()
//    }

    fun swapData(data: List<MatchHistoryModel.Result.Matches>) {
        this.data = data

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MatchHistoryModel.Result.Matches) = with(itemView) {

            matchNumberView.text = item.match_id.toString()

            //println(players)


            for ((index, player) in item.players.withIndex()) {
                println("item.players: $player")
                //convert 32 Bit steam id to 64 bit steam id
                //formula 76561197960265728 + 32 Steam ID

                val steamID64: Long = 76561197960265728 + player.account_id

                println(index)
                when (index) {
                    0 -> {
                        playerOne.text = steamID64.toString()
                    }
                    1 -> {
                        playerTwo.text = steamID64.toString()
                    }
                    2 -> {
                        playerThree.text = steamID64.toString()
                    }
                    3 -> {
                        playerFour.text = steamID64.toString()
                    }
                    4 -> {
                        playerFive.text = steamID64.toString()
                    }
                    5 -> {
                        playerSix.text = steamID64.toString()
                    }
                    6 -> {
                        playerSeven.text = steamID64.toString()
                    }
                    7 -> {
                        playerEight.text = steamID64.toString()
                    }
                    8 -> {
                        playerNine.text = steamID64.toString()
                    }
                    9 -> {
                        playerTen.text = steamID64.toString()
                    }
                }
            }

            // TODO: Bind the data with View
            setOnClickListener {
                // TODO: Handle on click

            }
        }

    }
}
