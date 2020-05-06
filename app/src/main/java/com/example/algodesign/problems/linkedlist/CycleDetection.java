package com.example.algodesign.problems.linkedlist;

public class CycleDetection  {
    /**
     * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
     */
     class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
      }


    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode fastPointer = head.next;
        SinglyLinkedListNode slowPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(fastPointer == slowPointer){
                return true;
            }
        }
        return false;
    }
}
