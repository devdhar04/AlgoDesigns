package com.example.algodesign.problems.linkedlist

import com.example.algodesign.utils.ProblemInterface
//https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3348/
class DeleteNodeInLinkedList : ProblemInterface {
   //Input: head = [4,5,1,9], node = 5
    fun deleteNode(node: ListNode?) {
        val next = node?.next
        if(next != null) {
            node.`val` = next.`val`
            node.next = node.next?.next
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    override fun execute() {
        val node = ListNode(4)
        node.next = ListNode(5)
        node.next!!.next = ListNode(1)
        node.next!!.next?.next = ListNode(9)

        deleteNode(node)
    }
}