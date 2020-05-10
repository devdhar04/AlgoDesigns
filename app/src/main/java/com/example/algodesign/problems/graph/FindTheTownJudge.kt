package com.example.algodesign.problems.graph

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class FindTheTownJudge : ProblemInterface {

    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        if (trust.isEmpty()) {
            return 1
        }
        val intArray = IntArray(N+1)
        trust.forEach {
            intArray[it.first()] = intArray[it.first()]-1
            intArray[it.last()] = intArray[it.last()]+1
        }
        for (i in 1..N) {
            if (intArray[i] === N - 1) return i
        }
        return -1
    }

    override fun execute() {

        val test = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )

        val test3 = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 3),
            intArrayOf(2, 4),
            intArrayOf(4, 3)
        )

        val test2 = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(6, 4),
            intArrayOf(3, 2),
            intArrayOf(2, 6),
            intArrayOf(4, 5),

            intArrayOf(6, 1),
            intArrayOf(1, 4),
            intArrayOf(1, 5),
            intArrayOf(2, 3),
            intArrayOf(2, 1),

            intArrayOf(4, 3),
            intArrayOf(4, 2),
            intArrayOf(2, 5),
            intArrayOf(4, 1),
            intArrayOf(2, 4),

            intArrayOf(6, 5),
            intArrayOf(3, 5)
        )

        //6
        //[[1,2],[6,4],[3,2],[2,6],[4,5],[6,1],[1,4],[1,5],[2,3],[2,1],[4,3],[4,2],[2,5],[4,1],[2,4],[6,5],[3,5]]
        Log.v("FindTheTownJudge", "findJudge ${findJudge(4, test3)}")
    }
}
