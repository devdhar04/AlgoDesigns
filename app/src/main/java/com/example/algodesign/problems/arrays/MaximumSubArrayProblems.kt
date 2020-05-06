package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
import kotlin.collections.HashMap

class MaximumSubArrayProblems : ProblemInterface {
     // [-2,1,-3,4,-1,2,1,-5,4],
     // HashMap = []
    fun maxSubArray(nums: IntArray): Int {
      val hashMap = HashMap<Int,Int>()
        var maxSum = 0
        nums.forEachIndexed { index, value ->
            if(index == 0){
                hashMap[index] = value // HashMap = [(0,-2)]
                maxSum = value
            }
            else{
                hashMap[index] = Math.max(hashMap[index-1]!!.plus(value),value) // // HashMap = [(0,-2),(1,1)]
                if(maxSum < hashMap[index]!!){
                    maxSum = hashMap[index]!!
                }
            }
        }

    return maxSum
    }

    override fun execute() {
        Log.v("maxSubArray ","maxSubArray ${maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))}")
    }

}
