package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.problems.ProblemInterface

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/
 */
class NumberOfIsland : ProblemInterface {

    fun numIslands(grid: Array<CharArray>): Int {
        var numberOfIsland = 0
        if(grid.isEmpty()){
            return numberOfIsland
        }
        grid.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if(c == '1') {
                    numberOfIsland += getIsland(grid, i, j)
                }
            }
        }
    return numberOfIsland
    }

    private fun getIsland(grid: Array<CharArray>,i : Int,j: Int) :  Int{
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[i].size || grid[i][j] === '0') {
            return 0;
        }
        grid[i][j] = '0'
        getIsland(grid,i-1,j)
        getIsland(grid,i,j-1)
        getIsland(grid,i+1,j)
        getIsland(grid,i,j+1)
    return 1
    }

    override fun execute() {
        Log.v(
            "numIslands",
            "numIslands ${numIslands(
                arrayOf(
                    charArrayOf('1', '1', '1', '1', '0'),
                    charArrayOf('1', '1', '0', '1', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )}"
        )
    }
}
