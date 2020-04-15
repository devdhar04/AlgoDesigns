package com.example.algodesign.graph

import android.util.Log

class AdjacencyList {

    val list = arrayOf(arrayOf(1))

    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        connections.forEach {
            it.forEach { value ->
                Log.d("data","$value")
            }
        }
        return 0
    }

}
