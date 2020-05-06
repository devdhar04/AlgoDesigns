package com.example.algodesign.problems.arrays

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/
class BuyandSellStockProblem : ProblemInterface {
    //7,1,5,3,6,4
    fun maxProfit(prices: IntArray): Int {
        var diff = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                diff += prices[i] - prices[i - 1]
            }
        }
        return diff
    }


    override fun execute() {

       Log.v("BuyandSellStockProblem","BuyandSellStockProblem ${maxProfit(intArrayOf(1,2,3,4,5))}")
    }

}
