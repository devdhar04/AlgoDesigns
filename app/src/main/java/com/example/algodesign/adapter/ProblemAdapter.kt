package com.example.algodesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.algodesign.R
import com.example.algodesign.databinding.ListItemBinding
import com.example.algodesign.model.Problem

class ProblemAdapter(private val list: List<Problem>) : RecyclerView.Adapter<ProblemAdapter.ProblemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProblemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProblemViewHolder(ListItemBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: ProblemViewHolder, position: Int) {
        val problem: Problem = list[position]
        holder.bind(problem)
    }

    override fun getItemCount(): Int = list.size

    class ProblemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(problem: Problem){
          binding.apply {
              problemTitle.text = problem.title
              problemDetail.text = problem.problemUrl
          }


        }
    }

    companion object{
        val problems = mutableListOf(
            Problem("First Bad Version",
                "https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/",
            ""),
            Problem("Jewels And Stones Problem",
                "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/",
                "")

        )

    }
}
