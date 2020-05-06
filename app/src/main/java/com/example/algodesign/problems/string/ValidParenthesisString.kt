package com.example.algodesign.problems.string

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
import java.util.*

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
 */
class ValidParenthesisString : ProblemInterface {

    fun checkValidString(s: String): Boolean {
        val openStack = Stack<Int>()
        val astreikStack = Stack<Int>()

        s.forEachIndexed { index, it ->
            val value = it.toString()
            if (value == "(") {
                openStack.push(index)
            } else if (value == "*") {
                astreikStack.push(index)
            } else {
                if(openStack.isNotEmpty()){
                    openStack.pop()
                }
                else if(astreikStack.isNotEmpty()){
                    astreikStack.pop()
                }
                else{
                    return false
                }
            }
        }

        while (openStack.isNotEmpty()){
            if(astreikStack.isEmpty()){
                return false
            }
            else if( openStack.peek() < astreikStack.peek()){
                openStack.pop()
                astreikStack.pop()
            }
            else{
                return false
            }

        }
        return true
    }

    override fun execute() {

      //  Log.v("execute", "checkValidString ${checkValidString(")(")}")
        //Log.v("execute", "checkValidString ${checkValidString("(*)")}")
        Log.v("execute", "checkValidString ${checkValidString("(*()")}")
        //Log.v("execute", "checkValidString ${checkValidString("*))")}")
    }
}
