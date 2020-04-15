package com.example.algodesign.problems


// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
class HappyNumberProblem : ProblemInterface {

    fun isHappy(n: Int): Boolean {
        val set = hashSetOf<Int>()
        if (n == 1)
            return true

        var current = n
        while (current != 1) {
            val numArray = current.toString().toCharArray()
            var result = 0
            numArray.forEach {
                result += it.toString().toInt().times(it.toString().toInt())
            }
            if (set.contains(result)) {
                return false
            }

            set.add(result)
            current = result

        }
        return true
    }

    override fun execute() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
