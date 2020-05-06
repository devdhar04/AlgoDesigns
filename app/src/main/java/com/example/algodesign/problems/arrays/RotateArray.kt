package com.example.algodesign.problems.arrays

import com.example.algodesign.utils.ProblemInterface

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
 */
class RotateArray : ProblemInterface {
    //[1,2,3,4,5,6,7] 3
    // 7,6,5,4,3,2,1
    fun rotate(nums: IntArray, k: Int): Unit {
        for (i in 0 until k) {
            var temp = nums[nums.size - 1]
            for (n in nums.size - 1 downTo 0) {
                if (n > 0) {
                    nums[n] = nums[n - 1]
                } else {
                    nums[0] = temp
                }
            }
        }
    }

    override fun execute() {
        rotate(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)

    }
}
