package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
import kotlin.math.min

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
 */
class MinimumPathSum : ProblemInterface {

    fun minPathSum(grid: Array<IntArray>): Int {
        val dpArray = grid.clone()

        grid.forEachIndexed { i, ints ->
            ints.forEachIndexed { j, value ->
                if (i > 0 && j > 0) {
                    Log.v(
                        "dpArray",
                        "dpArray[${i - 1}][$j] ${dpArray[i - 1][j]} dpArray[${i}][${j - 1}] ${dpArray[i][j - 1]}"
                    )
                    dpArray[i][j] += min(dpArray[i - 1][j], dpArray[i][j - 1])
                }
                else if(i > 0){
                    dpArray[i][j] += dpArray[i - 1][j]
                }
                else if(j >0){
                    dpArray[i][j] += dpArray[i][j - 1]
                }
            }
        }
        return dpArray[dpArray.size - 1][dpArray[0].size - 1]
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
