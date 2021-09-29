package com.example.cyphers_matching_search_system.matchingHistorySearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphers_matching_search_system.R
import com.example.cyphers_matching_search_system.databinding.MatchingViewItemBinding

class MatchingHistory_Recycler_Adapter : RecyclerView.Adapter<MatchingHistory_Recycler_Adapter.MyViewHolder>() {

    var MatchingHistory_listData = mutableListOf<MatchingHIstory_Recycler_Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = MatchingViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val member = MatchingHistory_listData[position]
        holder.setData(member)
    }

    override fun getItemCount(): Int {
        return MatchingHistory_listData.size
    }

    class MyViewHolder(val binding: MatchingViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun setData(member: MatchingHIstory_Recycler_Item){
            binding.first.text = member.name
        }

}