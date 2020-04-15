package com.example.algodesign.problems.linkedlist

import com.example.algodesign.problems.ProblemInterface


// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/
class MiddleOfLinkedListProblem: ProblemInterface{

    class ListNode(var `val`: Int) {
             var next: ListNode? = null
        }

    fun middleNode(head: ListNode?): ListNode? {
     var slowPointer = head
     var fastPointer = head?.next
     while (fastPointer != null){
         slowPointer = slowPointer?.next
         fastPointer = fastPointer?.next?.next
     }

    return slowPointer
    }


    override fun execute() {
        TODO("Not yet implemented")
    }

}
