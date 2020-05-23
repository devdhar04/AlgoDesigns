package com.example.algodesign.problems.graph

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
import kotlin.math.min

class CountSquareSubMatricesWithAllOnes : ProblemInterface {
 //https://leetcode.com/problems/count-square-submatrices-with-all-ones/

    //    Input: matrix =
//    [
//    [0,1,1,1],
//    [1,1,1,1],
//    [0,1,1,1]
//    ]
//
    private fun countSquares(matrix: Array<IntArray>): Int {
        var count = 0
        matrix.forEachIndexed { i, ints ->
            ints.forEachIndexed { j, value ->

                if (value > 0 && i > 0 && j > 0) {
                    matrix[i][j] =
                        min(matrix[i - 1][j - 1], min(matrix[i - 1][j], matrix[i][j - 1])) + 1
                }
                count += matrix[i][j]
            }
        }

        return count
    }

    override fun execute() {
        val input = arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(0, 1, 1, 1)
        )


        Log.v("countSquares", "countSquares ${countSquares(input)}")

    }
}
