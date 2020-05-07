package com.example.algodesign.problems.arrays

import com.example.algodesign.utils.ProblemInterface

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
 */
class RotateArray : ProblemInterface {
    //[1,2,3,4,5,6,7] 3
    // 7,6,5,4,3,2,1
    fun rotate(nums: IntArray, k: Int): Unit {
        var pivot = k % nums.size

        reverse(nums, 0, nums.size - 1)
        reverse(nums,0,pivot-1)
        reverse(nums,pivot,nums.size-1)

    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
            j--
        }
    }

    override fun execute() {
        rotate(intArrayOf(1,2,3,4,5,6,7), 3)

    }
}
