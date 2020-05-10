package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

//https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
class CheckStraightLine : ProblemInterface {

    private fun checkStraightLine(coordinates: Array<IntArray>): Boolean {

        if (coordinates[0][1] == coordinates[1][1]) {
            for (i in 2 until coordinates.size) {
                if (coordinates[i][1] != coordinates[0][1]) {
                    return false
                }
            }
            return true
        }

        var m = 0.toDouble()
        for (i in 1 until coordinates.size) {
            val prevArray = coordinates[i]
            val intArray = coordinates[i - 1]
            val x1 = prevArray.first()
            val y1 = prevArray.last()

            val x2 = intArray.first()
            val y2 = intArray.last()

            val m1 = (y2 - y1).toDouble() / (x2 - x1)
            if (m != 0.toDouble() && m != m1) {
                return false
            }
            Log.v("checkStraightLine", "checkStraightLine m1 $m1")
            m = m1
        }
        return true
    }

    // [[-4,-3],[1,0],[3,-1],[0,-1],[-5,2]]
    override fun execute() {
        Log.v(
            "checkStraightLine", "checkStraightLine ${checkStraightLine(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(5, 6),
                    intArrayOf(7, 7)
                )
            )}"
        )
    }
}
