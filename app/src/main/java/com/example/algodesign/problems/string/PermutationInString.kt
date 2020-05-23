package com.example.algodesign.problems.string

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class PermutationInString : ProblemInterface {

    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Hash = IntArray(26)
        val s2Hash = IntArray(26)
        val s2Len = s2.length

        if(s1.length > s2Len){
            return false
        }

        s1.forEachIndexed { index, it ->
            s1Hash[it - 'a'] += 1
            s2Hash[s2.elementAt(index) - 'a'] += 1
        }
        var index = s1.length - 1
        var start = 0
        while (index < s2Len) {
            if (s1Hash.contentEquals(s2Hash)) {
                return true
            }
            index += 1

            if(index != s2Len) {
                s2Hash[s2.elementAt(index) - 'a'] += 1
            }
            s2Hash[s2.elementAt(start) - 'a'] -= 1

            start += 1
        }
        return false
    }

    override fun execute() {
        Log.v("PermutationInString","checkInclusion ${checkInclusion("ab", "eidboaoo")}")
        Log.v("PermutationInString","checkInclusion ${checkInclusion("ab", "eidbaooo")}")

    }
}
