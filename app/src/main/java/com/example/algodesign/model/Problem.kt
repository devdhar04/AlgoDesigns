package com.example.algodesign.model

data class Problem (val title: String,
                    val problemUrl : String,
                    val solutionUrl: String,
                    val problemSourceType : ProblemSourceType)

enum class ProblemSourceType(val type: String){
    LEET_CODE("Leetcode"),
    HACKER_RANK("HackerRank")
}
