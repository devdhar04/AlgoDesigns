package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
import kotlin.math.max
import kotlin.math.min


class IntervalListIntersections : ProblemInterface {

    /**             2     5      10       1
     * Input: A = [[0,2],[5,10],[13,23],[24,25]],
     *             4       4      9      1
     *        B = [[1,5],[8,12],[15,24],[25,26]]
    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
     */
// Case 1
//   ax  -------- ay
//   bx     ------- by
    // Case 2
//   ax    -------- ay
//   bx  ------- by

    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {

        val aLen = A.size
        val bLen = B.size
        var i =0
        var j =0
        val result = mutableListOf<IntArray>()

           while (i< aLen && j< bLen) {

               val ax = A[i].first()
               val ay = A[i].last()
               val bx = B[j].first()
               val by = B[j].last()

               val resultX = max(ax, bx)
               val resultY = min(ay, by)
               if (resultY >= resultX) {
                   result.add(intArrayOf(resultX,resultY))
               }

               if (ay == resultY) {
                   i++
               }
               if (by == resultY) {
                   j++
               }

           }

        return result.toTypedArray()
    }

    override fun execute() {
        val A = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(5, 10),
            intArrayOf(13, 23),
            intArrayOf(24, 25)
        )

        val B = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(8, 12),
            intArrayOf(15, 24),
            intArrayOf(25, 26)
        )
        intervalIntersection(A, B)
    }
}
