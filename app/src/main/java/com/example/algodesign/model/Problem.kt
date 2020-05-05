package com.example.algodesign.model

data class Problem (val title: String,
                    val problemUrl : String,
                    val solutionUrl: String,
                    val problemSourceType : String)

enum class ProblemSourceType(val type: String){
    LEETCODE("LEETCODE"),
    HACKERRANK("HACKERRANK")
}
