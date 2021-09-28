package com.example.cyphers_matching_search_system.battleitemInfo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphers_matching_search_system.databinding.ItemBattleitemBinding

class BattleitemAdapter(val context: Context) : RecyclerView.Adapter<BattleitemAdapter.BattleitemViewHolder>() {

    private var battleitemList = ArrayList<BattleitemData>()

    inner class BattleitemViewHolder(val binding: ItemBattleitemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(battleitemData: BattleitemData){
            binding.data = battleitemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BattleitemViewHolder {
        val view = ItemBattleitemBinding.inflate(LayoutInflater.from(context), parent, false)
        return BattleitemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BattleitemViewHolder, position: Int) {
        holder.bind(battleitemList[position])
    }

    override fun getItemCount(): Int {
        return battleitemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<BattleitemData>){
        battleitemList = data
        notifyDataSetChanged()
    }
}
