package com.example.algodesign.problems.design

import com.example.algodesign.utils.ProblemInterface
import java.util.*

class MinimumStackProblem : ProblemInterface {

    override fun execute() {
        val minStack = MinStack()
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        minStack.getMin()  //--> Returns -3.
        minStack.pop()
        minStack.top()    //--> Returns 0.
        minStack.getMin()   //--> Returns -2.
    }
}

class MinStack() {

    /** initialize your data structure here. */
    val stack =  Stack<Int>()
    val minimumstack = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        if(minimumstack.isEmpty() || x<= minimumstack.peek()) {
            minimumstack.push(x)
        }
    }

    fun pop() {
        if(minimumstack.peek() == stack.peek()){
            minimumstack.pop()
        }
        stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
     return minimumstack.peek()
    }

}

