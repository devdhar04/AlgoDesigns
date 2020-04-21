package com.example.algodesign.problems.string

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
 */
class PerformStringShifts : ProblemInterface {
    // abc
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var readPointer = 0
        shift.forEach {
            if (it.first() == 0) {
                readPointer += it.last()
            } else {
                readPointer -= it.last()
            }
        }

        readPointer %= s.length

        if (readPointer > 0) {
            return s.substring(readPointer).plus(s.substring(0, readPointer))
        } else {
            return s.substring(s.length + readPointer, s.length)
                .plus(s.substring(0, s.length + readPointer))
        }
    }

    //
    // "yisxjwry"
    // [[1,8],[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]]

    override fun execute() {
        Log.v(
            "stringShift", "stringShift ${stringShift(
                "yisxjwry", arrayOf(
                    intArrayOf(1, 8),
                    intArrayOf(1, 4),
                    intArrayOf(1, 3),
                    intArrayOf(1, 6),
                    intArrayOf(0, 6),
                    intArrayOf(1, 4),
                    intArrayOf(0, 2),
                    intArrayOf(0, 1)

                )
            )}"
        )
    }
}
