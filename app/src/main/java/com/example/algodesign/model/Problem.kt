package com.example.algodesign.model

data class Problem(
    val title: String,
    val problemUrl: String,
    val solutionUrl: String,
    val problemSourceType: String,
    val problemType: String
)

enum class ProblemSourceType(val type: String) {
    LEETCODE("LEETCODE"),
    HACKERRANK("HACKERRANK")
}

enum class ProblemType(val type: String) {
    ARRAYS("ARRAYS"),
    LINKED_LIST("LINKED_LIST"),
    STRINGS("STRINGS"),
    GRAPHS("GRAPHS"),
    BINARY_SEARCH("BINARY_SEARCH"),
    TREE("TREE"),
    STACK("STACK"),
    DESIGN("DESIGN"),
    MATH("MATH")
}
