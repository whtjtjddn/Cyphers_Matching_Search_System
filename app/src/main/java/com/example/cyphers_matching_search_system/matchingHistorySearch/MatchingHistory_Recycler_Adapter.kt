package com.example.cyphers_matching_search_system.matchingHistorySearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cyphers_matching_search_system.R

class MatchingHistory_Recycler_Adapter : RecyclerView.Adapter<MatchingHistory_Recycler_Adapter.MyViewHolder>() {

    inner class MyViewHolder constructor(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.matching_view_item, parent, false)
    ){
        var re1 = itemView.findViewById<View>(R.id.first)
        var re2 = itemView.findViewById<View>(R.id.second)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        Log.e("datasize", "" + data.value!!.size)
        return data.value!!.size
    }
}