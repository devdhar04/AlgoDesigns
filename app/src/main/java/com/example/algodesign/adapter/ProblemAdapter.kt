package com.example.algodesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.algodesign.R
import com.example.algodesign.model.Problem

class ProblemAdapter(private val list: List<Problem>) : RecyclerView.Adapter<ProblemAdapter.ProblemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProblemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProblemViewHolder(inflater.inflate(R.layout.list_item,parent,false))
    }

    override fun onBindViewHolder(holder: ProblemViewHolder, position: Int) {
        val problem: Problem = list[position]
        holder.bind(problem)
    }

    override fun getItemCount(): Int = list.size

    class ProblemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(problem: Problem){

        }
    }
}
