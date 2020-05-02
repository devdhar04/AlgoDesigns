package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

class SearchInRotatedSortedArray : ProblemInterface {
    //Input: nums = [4,5,6,7,0,1,2], target = 0
    fun search(nums: IntArray, target: Int): Int {

        return binarySearch(nums, 0, nums.size-1, target)
    }


    private fun binarySearch(nums: IntArray, left: Int, right: Int, target: Int): Int {

        if(left > right){
            return -1
        }
        val mid = (left+right)/2
        if(nums[mid] == target){
            return mid
        }
        if(nums[left] <= nums[mid]){

            if(target >= nums[left] && target<= nums[mid]){
                return binarySearch(nums,left,mid-1,target)
            }
            return binarySearch(nums,mid+1,right,target)
        }

        if(target >= nums[mid] && target <= nums[right]){
            return binarySearch(nums,mid+1,right,target)
        }
        return binarySearch(nums,left,mid-1,target)
    }


    override fun execute() {
        Log.v(
            "RotatedSortedArray",
            "SearchInRotatedSortedArray ${search(intArrayOf(3,1), 3)}"
        )
    }
}
