package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
class CountingBits : ProblemInterface {

    fun countBits(num: Int): IntArray {

        val ans = IntArray(num+1)
        for(i in 1..num){
            ans[i] =  ans[i and (i-1)]+1

        }
    return ans
    }


    override fun execute() {

     Log.v("execute","execute ${countBits(5)}")
    }

}