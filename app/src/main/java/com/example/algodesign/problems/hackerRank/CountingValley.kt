package com.example.algodesign.problems.hackerRank

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

// https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

class CountingValley : ProblemInterface {

    /** UDDDUDUU
     *  _/\       _
           \    /
            \/\/
     */

    // UDDDUDUU
    fun countingValleys(n: Int, s: String): Int {
        var count = 0
        var numberOfValley = 0
        s.forEach {
            if (it == 'U') {
                count += 1
                if (count == 0) {
                    numberOfValley += 1
                }
            } else {
                count -= 1
            }
        }

        return numberOfValley
    }

    override fun execute() {
        Log.v("CountingValley","countingValleys ${countingValleys(8,"UDDDUDUU")}")
    }

}

