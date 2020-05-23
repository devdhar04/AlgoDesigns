package com.example.algodesign.problems.string

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class FindAllAnagram : ProblemInterface{
    // s: "cbaebabacd" p: "abc"
    fun findAnagrams(s: String, p: String): List<Int> {
        val mutableList = mutableListOf<Int>()
        var pMatch = p.toCharArray().sorted()
        var index = 0
        while (index<= (s.length - p.length)){
            var sMatch = s.substring(index,p.length+index).toCharArray().sorted()
            if(pMatch == sMatch){
                mutableList.add(index)
            }
            index++
        }

    return mutableList
    }

    override fun execute() {
        Log.v("findAnagrams","findAnagrams ${findAnagrams("abab","ab")}")
    }


}
