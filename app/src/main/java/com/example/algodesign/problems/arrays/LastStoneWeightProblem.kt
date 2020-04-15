package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
 *
 */
class LastStoneWeightProblem : ProblemInterface {
    // 2,7,4,1,8,1)
    fun lastStoneWeight(stones: IntArray): Int {
        val list = stones.sortedDescending().toMutableList()
        list.forEachIndexed { index, it ->
            if(index + 1 <= list.size-1) {
                val x = it
                val y = list[index + 1]
                if (index < list.size - 1) {
                    if (x == y) {
                        list.set(index + 1, 0)
                        list.set(index, 0)
                    } else if (x < y) {
                        list.set(index + 1, y - x)
                        list.set(index, 0)
                    } else { // x>y
                        list.set(index + 1, 0)
                        list.set(index, x - y)
                    }
                }
            }
        }
    return 0
    }



    override fun execute() {
        Log.v(
            "LastStoneWeightProblem",
            "LastStoneWeightProblem ${lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1))}"
        )
    }
}
