package com.example.algodesign.problems.linkedlist

import com.example.algodesign.utils.ProblemInterface

class OddEvenLinkedList : ProblemInterface {
    //S  F
    // Input: 1->2->3->4->5->NULL =>  1->3->5->2->4->NULL
    //1,3,2,4,5
    // S F
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next?.next == null) return head
        var slowPointer = head
        var fastPointer = head.next
        val temp = fastPointer

        while (fastPointer?.next != null) {
            slowPointer?.next = slowPointer?.next?.next
            fastPointer.next = fastPointer.next?.next

            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next

        }

        slowPointer?.next = temp

        return head
    }


    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    override fun execute() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next!!.next = ListNode(3)
        head.next!!.next!!.next = ListNode(4)
        head.next!!.next!!.next!!.next = ListNode(5)
        head.next!!.next!!.next!!.next!!.next = ListNode(6)
        head.next!!.next!!.next!!.next!!.next!!.next = ListNode(7)
        oddEvenList(head)


    }
}
