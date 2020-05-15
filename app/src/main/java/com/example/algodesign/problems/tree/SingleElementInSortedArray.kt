package com.example.algodesign.problems.tree

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class SingleElementInSortedArray : ProblemInterface {

    fun singleNonDuplicate(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1
        while(low < high){
            var mid = low + (high - low)/2
            if(mid % 2 == 1) mid--

            if(nums[mid] == nums[mid + 1]){
                low = mid + 2
            }else high = mid
        }

        return nums[high]
    }


    override fun execute() {
//         Log.v("singleNonDuplicate","singleNonDuplicate ${singleNonDuplicate(intArrayOf(1,1,2,3,3,4,4,8,8))}")
//        Log.v(
//            "singleNonDuplicate",
//            "singleNonDuplicate ${singleNonDuplicate(intArrayOf(3, 3, 7, 7, 10, 11, 11))}"
//        )
        Log.v(
            "singleNonDuplicate",
            "singleNonDuplicate ${singleNonDuplicate(intArrayOf(1, 1, 2, 2, 3))}"
        )
    }
}
