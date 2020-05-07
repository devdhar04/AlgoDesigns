package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class DuplicateInArray :ProblemInterface{

    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.forEach{it ->
            if(set.contains(it)){
                return true
            }
            else{
                set.add(it)
            }
        }
        return false
    }

    override fun execute() {
        Log.v("DuplicateInArray","DuplicateInArray ${containsDuplicate(intArrayOf(1,1,2,3,4,5))}")
    }
}
