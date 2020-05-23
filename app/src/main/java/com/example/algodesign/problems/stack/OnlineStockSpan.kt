package com.example.algodesign.problems.stack

import com.example.algodesign.utils.ProblemInterface
import java.util.*

class OnlineStockSpan : ProblemInterface {

    val stock = Stack<Int>()
    val array = mutableListOf<Int>()
    fun next(price: Int): Int {
        val span = 1
        while (stock.isNotEmpty() && price >= array[stock.peek()]) {


        }

        array.add(price)
        stock.push(array.size - 1)
        return span
    }

    override fun execute() {


    }
}
