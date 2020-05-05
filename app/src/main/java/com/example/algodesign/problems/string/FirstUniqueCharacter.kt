package com.example.algodesign.problems.string

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
 */
class FirstUniqueCharacter : ProblemInterface {

    // loveleetcode
    fun firstUniqChar(s: String): Int {
        if (s.isEmpty()) {
            return -1
        }

        val charMap = HashMap<Char, Int>()
        s.forEachIndexed { index, c ->
            if (charMap.containsKey(c)) {
                val freq = charMap[c]
                charMap[c] = freq!! + 1
            } else {
                charMap[c] = 1
            }
        }
        s.forEachIndexed { index, c ->
            if (charMap[c] == 1) {
                return index
            }
        }

        return -1
    }

    private fun secondSolution(s: String): Int {

        if (s.isEmpty()) {
            return -1
        }

        val arr = IntArray(26) { 0 }

        for (element in s) {
            arr[element - 'a']++
        }

        s.forEachIndexed { index, char ->
            if (arr[char - 'a'] == 1) {
                return index
            }
        }
        return -1
    }

    override fun execute() {
        Log.v("exceute", "firstUniqChar ${secondSolution("leetcode")}")
        Log.v("exceute", "firstUniqChar ${secondSolution("loveleetcode")}")
    }
}
