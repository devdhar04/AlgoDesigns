package com.example.algodesign.problems.hackerRank

// https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

fun countingValleys(n: Int, s: String): Int {
    var count = 0
    var numberOfValley = 0
  s.forEach {
      if(it == 'U'){
          count+=1
          if(count == 0){
              numberOfValley+=1
          }
      }
      else{
          count-=1
          if(count == 0){
              numberOfValley+=1
          }
      }

  }

  return  numberOfValley
}
