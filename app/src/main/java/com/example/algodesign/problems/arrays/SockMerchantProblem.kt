package com.example.algodesign.problems.arrays

/**
 * Problem Description
 * https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */

class SockMerchantProblem {

    /**
     * @param n = 9
     * @param ar = [10 20 20 10 10 30 50 10 20]
     */
    fun sockMerchant(n: Int, ar: Array<Int>): Int {

        val set = mutableSetOf<Int>()
        var pair = 0 ;
        ar.forEach {
            if(set.contains(it)){
                pair+=1
                set.remove(it)
            }
            else{
                set.add(it)
            }
        }
        return pair
    }

}
