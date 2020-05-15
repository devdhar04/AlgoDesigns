package com.example.algodesign.problems.graph

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

/*
https://leetcode.com/problems/flood-fill/
 */
class FloodFill : ProblemInterface {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        var visitedArray = Array(image.size) { BooleanArray(image[0].size) }

        for (i in 0 until image.size) {
            for (j in 0 until image[0].size) {
                visitedArray[i][j] = false
            }
        }

        fillUtil(image, sr, sc, newColor, image[sr][sc],visitedArray)

        return image
    }

    private fun fillUtil(
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        newColor: Int,
        oldColor: Int,
        visitedArray:Array<BooleanArray>
    ) {

        if (sr >= 0 && sr < image.size && sc >= 0 && sc < image[0].size) {

            if (visitedArray[sr][sc]) {
                return
            }
            if (image[sr][sc] == oldColor) {
                image[sr][sc] = newColor
                visitedArray[sr][sc] = true

                fillUtil(image, sr - 1, sc, newColor, oldColor,visitedArray)
                fillUtil(image, sr, sc - 1, newColor, oldColor,visitedArray)
                fillUtil(image, sr, sc + 1, newColor, oldColor,visitedArray)
                fillUtil(image, sr + 1, sc, newColor, oldColor,visitedArray )
            }
            return
        }
    }

    override fun execute() {
        //[[0,0,0],[0,1,1]]
        val input1 = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 1)
        )

        val input = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        Log.v("floodFill", "floodFill ${floodFill(input, 1, 1, 2)}")
    }
}
