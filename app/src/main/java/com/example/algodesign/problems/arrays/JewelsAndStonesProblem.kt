package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/

class JewelsAndStonesProblem : ProblemInterface {

    fun numJewelsInStones(J: String, S: String): Int {
        var jCount = 0
        val jMap = HashMap<String,Int>()
        J.forEach {
            jMap[it.toString()] = it.toInt()
        }
        S.forEach {
            if(jMap.containsKey(it.toString())){
                jCount+=1
            }
        }

    return  jCount
    }

    override fun execute() {
        Log.v("JewelsAndStonesProblem","JewelsAndStonesProblem ${numJewelsInStones("aA","aAAbbA")}")
    }
}
