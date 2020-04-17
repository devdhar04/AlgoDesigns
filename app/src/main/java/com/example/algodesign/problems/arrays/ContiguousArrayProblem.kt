package com.example.algodesign.problems.arrays

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
 */
import android.util.Log
import com.example.algodesign.problems.ProblemInterface
import kotlin.math.max

class ContiguousArrayProblem : ProblemInterface {
    //Input: [0,0,1,0,0,0,1,1]
    fun findMaxLength(nums: IntArray): Int {
        val hashMap = HashMap<Int, Int>()
        hashMap[0] = -1
        var count = 0
        var totalSum = 0


        nums.forEachIndexed { i, it ->
            if (it == 0) {
                count -= 1
            } else {
                count += 1
            }
            if (hashMap.containsKey(count)) {
                totalSum = max(totalSum, i - hashMap[count]!!)
            } else {
                hashMap[count] = i
            }
        }

        return totalSum
    }

    override fun execute() {
        Log.v(
            "ContiguousArrayProblem",
            "ContiguousArrayProblem ${findMaxLength(intArrayOf(1, 0))}"
        )
    }
}
