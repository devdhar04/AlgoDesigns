package com.example.algodesign.problems.binarySearch

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
 */
class NumberComplement : ProblemInterface {

    fun findComplement(num: Int): Int {
        var maxBinary = 1
        while (num > maxBinary) {
            maxBinary = maxBinary * 2 + 1
        }

        return maxBinary - num
    }
    override fun execute() {
      Log.v("NumberComplement" ,"NumberComplement ${findComplement(5)}")
    }
}
