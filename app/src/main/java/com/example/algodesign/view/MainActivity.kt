package com.example.algodesign.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.algodesign.R
import com.example.algodesign.databinding.ActivityMainBinding
import com.example.algodesign.problems.HappyNumberProblem
import com.example.algodesign.problems.arrays.*
import com.example.algodesign.problems.design.LruCache
import com.example.algodesign.problems.design.Trie
import com.example.algodesign.problems.graph.AdjacencyList
import com.example.algodesign.problems.graph.CountSquareSubMatricesWithAllOnes
import com.example.algodesign.problems.graph.FindTheTownJudge
import com.example.algodesign.problems.graph.FloodFill
import com.example.algodesign.problems.math.ValidPerfectSquare
import com.example.algodesign.problems.string.*
import com.example.algodesign.problems.tree.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(applicationContext))
        setContentView(binding.root)
        val host = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, host)
            .setPrimaryNavigationFragment(host).commit()



        Log.v(
            "SubArrayProblem", "SubArrayProblem ${SubArrayProblem()
                .subarraySum(intArrayOf(1, 2, 1, 2, 1), 3)}"
        )

        Log.v(
            "countSubstrings", "countSubstrings ${PalindromicSubstring()
                .countSubstrings("Bananas")}"
        )
        val charArray = charArrayOf('a', 'b', 'c', 'd', 'e')
        Anagram().minSteps("anagram", "mangaar")
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

        SingleNumberProblem().singleNumber(intArrayOf(1, 2, 3, 1, 2))

        Log.v("HappyNumberProblem", "HappyNumberProblem ${HappyNumberProblem().isHappy(1111111)}")
        Log.v(
            "ContiguousArrayProblem",
            "ContiguousArrayProblem ${ContiguousArrayProblem().execute()}"
        )
        LastStoneWeightProblem().execute()
        LruCache(2).execute()

        RemoveDuplicates().execute()
        RotateArray().execute()
        CousinsInBinaryTree().execute()
        TopViewOfBinaryTree().execute()
        ValidPerfectSquare().execute()
        FindTheTownJudge().execute()
        FloodFill().execute()
        SingleElementInSortedArray().execute()
        RemoveKDigit().execute()

        val trie = Trie()
        trie.insert("apple")
        trie.insert("aba")

        Log.v("Trie", "Trie Search ${trie.search("apple")}")
        Log.v("Trie", "Trie Search ${trie.startsWith("app")}")
        trie.insert("app")
        Log.v("Trie", "Trie Search ${trie.search("app")}")
        //Log.v("Trie", "Trie Search ${trie.search("bac")}")

//        OddEvenLinkedList().execute()
        BinaryTreeLevelOrderTraversal().execute()
        BinaryTreeZigzagLevelOrderTraversal().execute()
//        FindAllAnagram().execute()
        PermutationInString().execute()
        KthSmallestElementBST().execute()
        CountSquareSubMatricesWithAllOnes().execute()
        IntervalListIntersections().execute()
    }

    //'a','b','c','d'
    // https://leetcode.com/problems/reverse-string/submissions/
    fun reverseString(s: CharArray): Unit {

        s.forEachIndexed { index, c ->
            println("reverseString index ${s[s.size - index - 1]}")
            if (index < s.size / 2) {
                val extra = s[index]
                s[index] = s[s.size - index - 1]
                s[s.size - index - 1] = extra
            }
        }

        s.forEachIndexed { index, c ->
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
            if (nums[i] == nums.size - index) {

                return maxJump
            }
        }
        return 0
    }


}
