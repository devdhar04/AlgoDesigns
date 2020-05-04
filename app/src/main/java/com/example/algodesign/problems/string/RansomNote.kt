package com.example.algodesign.problems.string

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
 */
class RansomNote : ProblemInterface {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {

        val magazineMap = HashMap<String, Int>()
        magazine.forEach {
            if (magazineMap.containsKey(it.toString())) {
                val count = magazineMap[it.toString()]
                magazineMap[it.toString()] = count!!.plus(1)
            } else {
                magazineMap[it.toString()] = 1
            }

        }
        ransomNote.forEach {
            if (magazineMap[it.toString()] != null) {
                var count = magazineMap[it.toString()]
                if (count!! > 0) {
                    magazineMap[it.toString()] = count.minus(1)
                } else {
                    return false
                }

            } else {
                return false
            }
        }


        return true
    }

    override fun execute() {
        Log.v("Ransome Note", "Ransome Note ${canConstruct("aa","aab")}")
        Log.v("Ransome Note", "Ransome Note ${canConstruct("fffbfg","effjfggbffjdgbjjhhdegh")}")

    }

}
