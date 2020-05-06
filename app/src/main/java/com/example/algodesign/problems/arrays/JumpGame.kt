package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class JumpGame : ProblemInterface {

    /**
     * 3,2,1,0,4
     * |-|-|-|
     */
    fun canJump(nums: IntArray): Boolean {
    var ladder = nums.first()
        nums.forEachIndexed { index, i ->
            if(ladder <= index && i == 0){
                return false
            }
        }

        return true
    }


    override fun execute() {

        Log.v("JumpGame","JumpGame ${canJump(intArrayOf(3,2,1,0,4))}")
    }
}
