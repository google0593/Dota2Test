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
            val players = mutableListOf(item.players)
            println(players)


            for ((index, player) in item.players.withIndex()) {
                println("item.players: $player")
                println(index)
                when (index) {
                    0 -> {
                        playerOne.text = player.account_id.toString()
                    }
                    1 -> {
                        playerTwo.text = player.account_id.toString()
                    }
                    2 -> {
                        playerThree.text = player.account_id.toString()
                    }
                    3 -> {
                        playerFour.text = player.account_id.toString()
                    }
                    4 -> {
                        playerFive.text = player.account_id.toString()
                    }
                    5 -> {
                        playerSix.text = player.account_id.toString()
                    }
                    6 -> {
                        playerSeven.text = player.account_id.toString()
                    }
                    7 -> {
                        playerEight.text = player.account_id.toString()
                    }
                    8 -> {
                        playerNine.text = player.account_id.toString()
                    }
                    9 -> {
                        playerTen.text = player.account_id.toString()
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
