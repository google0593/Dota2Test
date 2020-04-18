package com.example.dota2test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2test.dto.MatchHistoryModel
import kotlinx.android.synthetic.main.match_history.view.*
import kotlin.collections.ArrayList

class DotaMatchHistoryAdapter() : RecyclerView.Adapter<DotaMatchHistoryAdapter.ViewHolder>() {
    //var data: List<MatchHistoryList> = ArrayList()
    var data: List<MatchHistoryModel.Result.Matches> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.match_history, parent, false)
        )
    }

    override fun getItemCount() = data.size

    //    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.itemView.testView.text = data[position].match_id.toString()
    }

    fun swapData(data: List<MatchHistoryModel.Result.Matches>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MatchHistoryModel.Result.Matches) = with(itemView) {
            //itemView.testView.text = item.result.result.matches.indexOf
            val tvMovieName: TextView = itemView!!.findViewById(R.id.testView)
            //println("find me: $str")


            // TODO: Bind the data with View
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}
