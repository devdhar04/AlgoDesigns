package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

/**
 * Remove Duplicates from Sorted Array
   https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
 */
class RemoveDuplicates : ProblemInterface{
    //[0,0,1,1,1,2,2,3,3,4] index = 1 a[1] = 0
    // a[i] == a[i-1] => 0 == 0
    // temp = a[i]
    // a[i] = a[i+1]
    // [i+1] = a   =>[1,2,1] index = 2
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 2) return nums.size
        var id = 1
        for (i in 1 until nums.size) {
            if (nums[i] !== nums[i - 1])
                nums[id++] = nums[i]
        }
        return id
    }

    override fun execute() {
        Log.v("element","1 element ${removeDuplicates(intArrayOf(0,0,0,1,1,1,2,2,3,3,4))}")
    }

}
