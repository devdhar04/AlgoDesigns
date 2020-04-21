package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
 */
class MinimumPathSum : ProblemInterface {

    fun minPathSum(grid: Array<IntArray>): Int {

    }

    override fun execute() {
        Log.v(
            "MinimumPathSum", "MinimumPathSum ${minPathSum(
                arrayOf(
                    intArrayOf(1, 3, 1),
                    intArrayOf(1, 5, 1),
                    intArrayOf(4, 2, 1)
                )
            )}"
        )

    }
}
