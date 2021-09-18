package com.example.cyphers_matching_search_system.battleitemInfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphers_matching_search_system.R

class BattleitemAdapter(val context: Context, val battleitemList: ArrayList<BattleitemData>) : RecyclerView.Adapter<BattleitemAdapter.BattleitemViewHolder>() {

    inner class BattleitemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var _battleitemName = ObservableField<String>()
        var _battleitemIamge = ObservableField<String>()

        fun bind(battleitemData: BattleitemData, context: Context){
            _battleitemName.set(battleitemData.itemName)
            _battleitemName.set("battleitemData.itemName")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BattleitemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_battleitem, parent, false)
        return BattleitemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BattleitemViewHolder, position: Int) {
        holder.bind(battleitemList[position], context)
    }

    override fun getItemCount(): Int {
        return battleitemList.size
    }
}
