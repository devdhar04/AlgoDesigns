package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class GroupAnagramProblem : ProblemInterface {

    /**
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     Output:
    [
    ["ate","eat","tea"],
    ["nat","tan"],
    ["bat"]
    ]
     */
    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
    fun groupAnagrams(strs: Array<String>): List<List<String>>? {
        val map =  hashMapOf<String,MutableList<String>>()
        strs.forEach {
            val ana = it.toCharArray().sortedArray().joinToString("")

            if(map[ana] == null) {
                val list = mutableListOf<String>(it)
                map[ana] = list
            }
            else{
                map[ana]!!.add(it)
            }
        }
        val result = mutableListOf<MutableList<String>>()
        map.keys.forEach {
            result.add(map[it]!!)
        }
        return result
    }

    override fun execute() {
        val arrays = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
        Log.v("","${groupAnagrams(arrays)}")
    }
}
