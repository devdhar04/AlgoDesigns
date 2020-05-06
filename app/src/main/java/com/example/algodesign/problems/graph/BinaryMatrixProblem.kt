package com.example.algodesign.problems.graph

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
class BinaryMatrixProblem : ProblemInterface {

    class BinaryMatrix { //[[0,0,0,1],[0,0,1,1],[0,1,1,1]]
        private val input = arrayOf(
            intArrayOf(0, 0, 0, 1),
            intArrayOf(0, 0, 1, 1),
            intArrayOf(0, 1, 1, 1)
        )

        fun get(row: Int, col: Int): Int {
            return input[row][col]
        }

        fun dimensions(): List<Int> {
            return listOf(input.size, input[0].size)
        }
    }

    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val (row,col) = binaryMatrix.dimensions()

        return traverse(binaryMatrix ,binaryMatrix.dimensions())
    }

    fun traverse(binaryMatrix : BinaryMatrix,size: List<Int>) :  Int{
        var i = 0
        var j = size.last()-1
        var lastCol = -1
        while (i<size.first() && j>=0){
           val value =  binaryMatrix.get(i,j)
            if(value == 0){
                i+=1
            }else{
                lastCol = j
                j-=1
            }
        }

    return lastCol
    }

    override fun execute() {
        Log.v("BinaryMatrixProblem", "BinaryMatrixProblem ${leftMostColumnWithOne(BinaryMatrix())}")
    }
}
