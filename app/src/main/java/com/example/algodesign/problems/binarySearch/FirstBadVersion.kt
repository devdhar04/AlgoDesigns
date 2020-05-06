package com.example.algodesign.problems.binarySearch

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class FirstBadVersion : ProblemInterface {
/*
https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
 */

    private fun isBadVersion(version: Int): Boolean  {
      if(version == 2){
          return true
      }
    return false
    }

    fun firstBadVersion(n: Int) : Int {
        var start = 0
        var end = n
        var mid = 0
        while (start<=end){
         mid = start + (end-start)/2
            if(isBadVersion(mid)){
              end = mid-1
            }
            else{
                start = mid+1
            }
        }
       if(!isBadVersion(mid)){
           return mid+1
       }

     return mid
    }


    override fun execute() {
     Log.v("firstBadVersion","firstBadVersion ${firstBadVersion(5)}")
    }
}
