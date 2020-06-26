package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class PossibleBipartition : ProblemInterface {

    //Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {

        val adjMap = Array<MutableList<Int>>(N + 1) { mutableListOf() }

        dislikes.forEach {
            val list = adjMap[it.first()]
            list.add(it.last())
            adjMap[it.first()] = list

            val list1 = adjMap[it.last()]
            list1.add(it.first())
            adjMap[it.last()] = list1

        }

        val color = Array<Int>(N + 1) { -1 }
        var previousColor = -1
        for (index in 1.. adjMap.size)
        {
            val mutableList = adjMap[index]
            if (previousColor == 0) {
                previousColor = 1
            } else if (previousColor == 1) {
                previousColor = 0
            } else {
                previousColor = 0
            }

            if (color[index] == -1 || color[index] == previousColor) {
                color[index] = previousColor
            } else {
                return false
            }
            mutableList.forEachIndexed { index, i ->
                when (previousColor) {
                    0 -> {
                        if (color[i] == 0) {
                            return false
                        }
                        color[i] = 1
                    }
                    1 -> {
                        if (color[i] == 1) {
                            return false
                        }
                        color[i] = 0
                    }
                }
            }

        }


        return true

    }

    override fun execute() {
        val input  = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3), intArrayOf(2, 4)
        )
        Log.v("possibleBipartition","possibleBipartition ${possibleBipartition(4, input)}")
    }
}