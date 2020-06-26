package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class ReverseArray : ProblemInterface{

    fun reverseString(s: CharArray): Unit {
        reverse(s,0,s.size-1)
    }

    private fun reverse(nums: CharArray, start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
            j--
        }
    }

    override fun execute() {
        Log.v("reverseString","reverseString ${reverseString(charArrayOf('h','e','l','l','o'))}")

    }
}