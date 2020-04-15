package com.example.algodesign.problems

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
class SubArrayProblem {

    // [-1,-1,-1], k = 0
    fun subarraySum(nums: IntArray, k: Int): Int {
        var sum = 0
        var numOfSubArray = 0
        nums.forEach {
            if (it == k) {
                numOfSubArray += 1
                sum = 0
            } else {
                    if (sum + it > k) {
                        sum = 0
                    } else {
                        sum += it
                        if (sum == k) {
                            numOfSubArray += 1
                            sum = it
                        }
                    }
            }
        }
        return numOfSubArray
    }

}
