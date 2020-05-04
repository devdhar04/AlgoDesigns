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
                val iconDrawable = when (problem.problemSourceType) {
                    ProblemSourceType.HACKER_RANK -> {
                        R.drawable.ic_launcher_background
                    }
                    ProblemSourceType.LEET_CODE -> {
                     R.drawable.ic_leetcode
                    }
                }
                icon.setImageDrawable(ContextCompat.getDrawable(icon.context,iconDrawable))
                itemView.setOnClickListener {
                    itemClick.onClick(problem)
                }
            }
        }
    }

    companion object {
        val problems = mutableListOf(
            Problem(
                "First Bad Version",
                "https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/",
                "https://gist.github.com/devdhar04/1f728fbfdffd4e5112ad524cfdcd9675",
                ProblemSourceType.LEET_CODE
            ),
            Problem(
                "Jewels And Stones Problem",
                "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/",
                "https://gist.github.com/devdhar04/b4f1df7aeb08f987e28a9a49da43d5b4",
                ProblemSourceType.LEET_CODE
            ),
            Problem(
                "Ransom Note Problem",
                "https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/",
                "https://gist.github.com/devdhar04/60cdc323558692ec459306c776b71db7",
                ProblemSourceType.LEET_CODE
            )

        )

    }

    interface ItemClickListener {
        fun onClick(problem: Problem)
    }
}
