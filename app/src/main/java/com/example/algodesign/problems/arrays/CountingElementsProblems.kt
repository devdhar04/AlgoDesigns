package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
class CountingElementsProblems : ProblemInterface {
    /**
     * Input: arr = [1,3,2,3,5,0]
    Output: 3
    Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
     */

    fun countElements(arr: IntArray): Int {

        var count = 0
        // 2,9,0,7,6,2,7,7,0
        val sortedArray = arr.sortedArray() // 0,0,2,2,6,7,7,7,9

        var skip = 0
        sortedArray.forEachIndexed { index, value ->
            if (index < sortedArray.size - 1 ) {
                if(value + 1 == sortedArray[index + 1]) {
                    count += 1
                    count += skip
                    skip = 0
                }
                else if(value == sortedArray[index + 1]){
                    skip+=1
                }
                else{
                    skip = 0
                }
            }
        }
        return count
    }

    override fun execute() {
        Log.v("countElements","countElements ${countElements(intArrayOf(2,9,0,7,6,2,7,7,0))}")
    }
}
