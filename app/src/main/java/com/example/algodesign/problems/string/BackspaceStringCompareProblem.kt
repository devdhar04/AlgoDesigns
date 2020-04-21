package com.example.algodesign.problems.string

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
class BackspaceStringCompareProblem : ProblemInterface {
    /**
     * Input: S = "a##c", T = "#a#c"
     */
    fun backspaceCompare(S: String, T: String): Boolean {
        if (S.length in 1..200 && T.length in 1..200) {
            if (getBackSpaceString(S) == getBackSpaceString(T)) {
                return true
            }
        }
        return false
    }

    private fun getBackSpaceString(str: String): String {
        var s = ""
        var skipCount = 0

        for (i in str.toCharArray().size - 1 downTo 0) {
            if (str.elementAt(i).toString() == "#") {
                skipCount += 1
            } else {
                if (skipCount == 0) {
                    s = str.elementAt(i).toString().plus(s)
                } else if (skipCount > 0) {
                    skipCount -= 1
                }
            }
        }
        return s
    }

    override fun execute() {
        Log.v("backspaceCompare", "backspaceCompare ${backspaceCompare("a##c", "#a#c")}")
    }
}
