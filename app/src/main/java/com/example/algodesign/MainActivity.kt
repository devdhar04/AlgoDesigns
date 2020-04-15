package com.example.algodesign

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.algodesign.problems.SubArrayProblem
import com.example.algodesign.databinding.ActivityMainBinding
import com.example.algodesign.graph.AdjacencyList
import com.example.algodesign.problems.BuyandSellStockProblem
import com.example.algodesign.problems.HappyNumberProblem
import com.example.algodesign.problems.arrays.*
import com.example.algodesign.problems.stack.MinimumStackProblem
import com.example.algodesign.problems.tree.BinaryTreeDiameter
import com.example.algodesign.string.Anagram
import com.example.algodesign.string.BackspaceStringCompareProblem
import com.example.algodesign.strings.PalindromicSubstring



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("SubArrayProblem","SubArrayProblem ${SubArrayProblem().subarraySum(intArrayOf(-1,-1,1),0)}")

        Log.v("countSubstrings","countSubstrings ${PalindromicSubstring().countSubstrings("Bananas")}")
        val charArray = charArrayOf('a','b','c','d','e')
        Anagram().minSteps("anagram","mangaar")
        AdjacencyList()
            .makeConnected(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
                )
            )
        reverseString(charArray)
        val intArray = intArrayOf(1,1,1,2,2,3)
        removeDuplicates(intArray)
        intArray.forEach {
            println("removeDuplicates $it")
        }
        SingleNumberProblem().singleNumber(intArrayOf(1,2,3,1,2))

        Log.v("HappyNumberProblem","HappyNumberProblem ${ HappyNumberProblem().isHappy(1111111)}")
        Log.v("BinaryTreeDiameter","BinaryTreeDiameter ${ BinaryTreeDiameter().execute()}")
        LastStoneWeightProblem().execute()

    }
    //'a','b','c','d'
    // https://leetcode.com/problems/reverse-string/submissions/
    fun reverseString(s: CharArray): Unit {

        s.forEachIndexed{index, c ->
            println("reverseString index ${s[s.size-index-1]}")
            if(index< s.size/2) {
                val extra = s[index]
                s[index] = s[s.size - index - 1]
                s[s.size - index - 1] = extra
            }
        }

        s.forEachIndexed{index, c ->
            println("reverseString $c")
        }
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    // 1,1,1,2,2,3
    fun removeDuplicates(nums: IntArray): Int {
        var index = 2
        for (i in 2 until nums.size) {
            if (nums[i] !== nums[index - 2]) {
                nums[index] = nums[i]
                index++
            }
        }

    return index
    }
    // Input : [2,3,1,1,4]
    //https://leetcode.com/problems/jump-game-ii/
    fun jump(nums: IntArray): Int {
        var maxJump = 0
        nums.forEachIndexed { index, i ->
            if(nums[i] == nums.size - index){

                return maxJump
            }
        }
        return 0
    }

}
