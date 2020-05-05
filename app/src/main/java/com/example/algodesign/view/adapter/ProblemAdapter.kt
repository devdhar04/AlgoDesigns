package com.example.algodesign.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.algodesign.R
import com.example.algodesign.databinding.ListItemBinding
import com.example.algodesign.model.Problem
import com.example.algodesign.model.ProblemSourceType

class ProblemAdapter(private val list: List<Problem>, val itemClick: ItemClickListener) :
    RecyclerView.Adapter<ProblemAdapter.ProblemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProblemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProblemViewHolder(ListItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ProblemViewHolder, position: Int) {
        val problem: Problem = list[position]
        holder.bind(problem)
    }

    override fun getItemCount(): Int = list.size

    inner class ProblemViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(problem: Problem) {
            binding.apply {
                problemTitle.text = problem.title
                problemDetail.text = problem.problemUrl
                val iconDrawable = when (ProblemSourceType.valueOf(problem.problemSourceType)) {
                    ProblemSourceType.HACKERRANK -> {
                        R.drawable.ic_hacker_rank
                    }
                    ProblemSourceType.LEETCODE -> {
                        R.drawable.ic_leetcode
                    }
                }
                icon.setImageDrawable(ContextCompat.getDrawable(icon.context, iconDrawable))
                itemView.setOnClickListener {
                    itemClick.onClick(problem)
                }
            }
        }
    }


    interface ItemClickListener {
        fun onClick(problem: Problem)
    }
}
