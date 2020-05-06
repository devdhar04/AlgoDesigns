package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class MajorityElement : ProblemInterface {

    fun majorityElement(nums: IntArray): Int {
        val count = nums.size/2
        return nums.sortedArray()[count]
    }

    override fun execute() {

    Log.v("MajorityElement","majorityElement ${majorityElement(intArrayOf(2,2,1,1,1,2,2))}")
    }
}
