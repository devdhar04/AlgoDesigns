package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.problems.ProblemInterface
//https://leetcode.com/problems/move-zeroes/
class MoveZeroesProblem : ProblemInterface {
    //[0,1,0,3,12]
    fun moveZeroes(nums: IntArray): Unit {
        var j = 0
        nums.forEachIndexed { index, value ->
            if(value != 0){
                nums[j++] = value
            }
        }

        for(n in j until nums.size){
            nums[n] = 0
        }

        nums.forEach {
            Log.v("MoveZeroesProblem","MoveZeroesProblem ${it}")
        }

    }

    override fun execute() {
        moveZeroes(intArrayOf(0, 1, 0, 3, 12))
    }


}
