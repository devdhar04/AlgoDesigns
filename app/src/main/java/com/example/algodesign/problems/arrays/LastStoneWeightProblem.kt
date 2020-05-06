package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
import java.util.*

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
 *
 */
class LastStoneWeightProblem : ProblemInterface {
    // 2,7,4,1,8,1)
    fun lastStoneWeight(stones: IntArray): Int {

        val maxHeap = PriorityQueue<Int>()
        stones.forEach {
            maxHeap.add(-it)
        }
        while (maxHeap.size > 1) {
            val x = -maxHeap.remove()
            val y = -maxHeap.remove()
            if (x < y) {
                maxHeap.add(-(y - x))
            } else if (x > y) {
                maxHeap.add(-(x - y))
            }
        }
        return if(maxHeap.isEmpty()) 0 else -maxHeap.first()
    }


    override fun execute() {
        Log.v(
            "LastStoneWeightProblem",
            "LastStoneWeightProblem ${lastStoneWeight(intArrayOf(2, 2))}"
        )
    }
}
