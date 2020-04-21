package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
 */
class ProductOfArray :ProblemInterface{

    /**
     *  1,2,3,4
     */
    fun productExceptSelf(nums: IntArray): IntArray {
        val prodcutBefore = hashMapOf<Int,Int>()
        val prodcutAfter = hashMapOf<Int,Int>()
        var bProduct = 1
        nums.forEachIndexed { index, it ->
            bProduct *= it
            prodcutBefore[index] = bProduct
        }
        var aProduct = 1
        for (i in nums.size-1 downTo 0){
            aProduct *= nums[i]
            prodcutAfter[i] = aProduct
        }
        nums.forEachIndexed { index, it ->
            if(index == 0){
                nums[index] = prodcutAfter[index+1]!!
            }
            else if(index< nums.size-1){
                nums[index] = prodcutAfter[index+1]!!.times(prodcutBefore[index-1]!!)
            }
            else{
                nums[index] = prodcutBefore[index-1]!!
            }

        }
       return  nums
    }

    override fun execute() {
        Log.v("productExceptSelf ","productExceptSelf ${productExceptSelf(intArrayOf(1,2,3,4))}")
    }
}
