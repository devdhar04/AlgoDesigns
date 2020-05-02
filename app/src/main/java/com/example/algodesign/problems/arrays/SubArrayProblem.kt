package com.example.algodesign.problems.arrays

import android.os.Build
import androidx.annotation.RequiresApi

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3307/
class SubArrayProblem {

    // [-1,-1,1], k = 0
    @RequiresApi(Build.VERSION_CODES.N)
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map: HashMap<Int, Int> = HashMap()
        map[0] = 1

        var count = 0
        var sum = 0

        //e.g., 1 1 2 1 1

        //e.g., 1 1 2 1 1
        for (element in nums) {
            sum += element
            val n = map.getOrDefault(sum - k, 0)
            count += n
            map[sum] = map.getOrDefault(sum, 0) + 1
        }

        return count
    }

}
