package com.example.algodesign.problems.knapsack

class Knapsack {

    // Problem statement
    private val weight = intArrayOf(1,2,3)
    private val values = intArrayOf(6,10,12)
    private val maxWeight =  5



    private fun knapsackAlog(){

        val problemArray: Array<IntArray> = arrayOf(weight, values)

        problemArray.forEach {

            it.forEach { value->
                println(value)
            }
        }

    }


}
