package com.example.algodesign.problems.math

import com.example.algodesign.utils.ProblemInterface

class PowerOfTwo : ProblemInterface {

    fun isPowerOfTwo(n: Int): Boolean {

        return n > 0 && n and n - 1 === 0
    }

    override fun execute() {


    }
}