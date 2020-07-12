package com.mhmmd.TestApplication.ui.main.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhmmd.TestApplication.R
import com.mhmmd.TestApplication.data.model.db.GameEntity

class MainAdaptor(
    private val games: ArrayList<GameEntity>
) : RecyclerView.Adapter<MainAdaptor.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: GameEntity) {
            itemView.player_one_name.text = game.player_one
            itemView.player_two_name.text = game.player_two
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.game_item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(games[position])

    fun addData(list: List<GameEntity>) {
        games.addAll(list)
    }

}