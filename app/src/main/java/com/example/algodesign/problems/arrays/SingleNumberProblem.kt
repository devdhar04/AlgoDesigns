package com.example.algodesign.problems.arrays

// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/

class SingleNumberProblem {
    fun singleNumber(nums: IntArray): Int {
        var num = 0
        for (value in nums) {
            num = num.xor(value)
        }
        return num
    }
}
