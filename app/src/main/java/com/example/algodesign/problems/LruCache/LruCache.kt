package com.example.algodesign.problems.LruCache

import android.util.Log
import com.example.algodesign.problems.ProblemInterface


class LruCache(val capacity: Int) : ProblemInterface {
    val map = HashMap<Int, Node>()
    var head: Node? = null
    var end: Node? = null

    class Node(val key: Int, var value: Int) {
        var next: Node? = null
        var prev: Node? = null
    }

    fun get(key: Int): Int {

        if(map.isEmpty()){
            return -1
        }
        val node = map[key]
        if(node != null){
            removeNode(node)
            addNode(node)
        }


        return map[key]?.value ?: -1
    }

    private fun addNode(node: Node) {
        val head_next = node?.next
        head?.next = node
        node.prev = head
        node.next = head_next
        head_next?.prev = node
    }

    private fun removeNode(node: Node) {
        val nextNode = node.next
        val prevNode = node.prev
        prevNode?.next = nextNode
        nextNode?.prev = prevNode
    }


    fun put(key: Int, value: Int) {
        if (map[key] != null) {
            val node = map[key]
            removeNode(node!!)
            node.value = value
            addNode(node)
            map[key] = node
        } else {
            val node = Node(key, value)
            if (map.size == capacity) {
                end?.prev?.let {
                    removeNode(it)
                }
                map.remove(end?.prev?.key)
            }

            map[key] = node
            addNode(node)
        }
    }

    override fun execute() {
        val cache = LruCache(2 /* capacity */)

        cache.put(1, 1)
        cache.put(2, 2)
        Log.v("cache.get(1)", "cache.get(1) ${cache.get(1)}")
        //cache.get(1) // returns 1

        cache.put(3, 3) // evicts key 2

        Log.v("cache.get(2) ", "cache.get(2) ${cache.get(2)}")// returns -1 (not found)

        cache.put(4, 4) // evicts key 1

        Log.v("cache.get(1) ", "cache.get(1) ${cache.get(1)}") // returns -1 (not found)

        Log.v("cache.get(3) ", "cache.get(3) ${cache.get(3)}")// returns 3

        Log.v("cache.get(4) ", "cache.get(4) ${cache.get(4)}") //returns 4
    }
}
