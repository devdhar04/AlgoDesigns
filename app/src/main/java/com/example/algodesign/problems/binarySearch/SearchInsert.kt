package com.example.algodesign.problems.binarySearch

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class SearchInsert : ProblemInterface {

    // Input: [1,3,5,6], 2
    fun searchPosition(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        var mid = 0
        while (start <= end) {
            mid = start + (end - start) / 2
            if (nums[mid] == target) {
                return mid
            }
            else if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return start
    }

    override fun execute() {
        Log.v("searchPosition", "searchPosition ${searchPosition(intArrayOf(1, 3, 5, 6), 7)}")

    }
}