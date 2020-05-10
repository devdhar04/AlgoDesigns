package com.example.algodesign.problems.math

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class ValidPerfectSquare : ProblemInterface{

    //1,4,9,16,25,36,49,64,81
    //3 ,5, 7 , 9, 11, 13, 15 , 17

    //16

    fun isPerfectSquare(num: Int): Boolean {
        var t = num .toLong()
        while (t * t > num) {
            t = (t + num / t) / 2
        }
        return t*t==num.toLong()
    }

    override fun execute() {
        Log.v("ValidPerfectSquare" ,"isPerfectSquare ${isPerfectSquare(16)}")
        Log.v("ValidPerfectSquare" ,"isPerfectSquare ${isPerfectSquare(2)}")
        Log.v("ValidPerfectSquare" ,"isPerfectSquare ${isPerfectSquare(1)}")

    }
}
