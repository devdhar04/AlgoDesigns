package com.example.algodesign.problems.tree

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
 */
class ConstructBTreePreOrderTraversal :
    ProblemInterface {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        val node = buildTree(preorder, Index(),preorder[0], Int.MIN_VALUE, Int.MAX_VALUE,preorder.size)
        printInorder(node)
        return node
    }

    internal class Index {
        var index = 0
    }



    private fun buildTree( preorder: IntArray,preIndex : Index,key: Int, min: Int,max: Int,size:Int) : TreeNode?{

        if (preIndex.index >= size) {
            return null
        }

        var node : TreeNode? = null

        if(key > min && key< max){
            node = TreeNode(key)
            preIndex.index+= 1
            if(preIndex.index < size){
                node.left = buildTree(preorder,preIndex, preorder[preIndex.index],min,key,size)

            }
            if(preIndex.index < size) {
                node.right = buildTree(preorder, preIndex, preorder[preIndex.index], key, max, size)
            }
        }
    return node
   }

    fun printInorder(node: TreeNode?) {
        if (node == null) {
            return
        }
        printInorder(node.left)
        Log.v("Node","Node ${node.`val` }")
        printInorder(node.right)
    }

    class Solution {
        fun bstFromPreorder(preorder: IntArray): TreeNode? {
            return bstFromPreorder(preorder, 0, preorder.size)
        }

        private fun bstFromPreorder(preorder: IntArray, start:Int, end:Int): TreeNode? {
            if (start >= end || start == preorder.size) {
                return null
            }
            val root = TreeNode(preorder[start])
            var i = start + 1
            while (i < end && preorder[start] > preorder[i]) {
                i++
            }
            root.left = bstFromPreorder(preorder, start + 1, i)
            root.right = bstFromPreorder(preorder, i, end)
            return root
        }
    }

    override fun execute() {
        Log.v(
            "ConstructBTreePre",
            "ConstructBTreePreOrderTraversal ${bstFromPreorder(intArrayOf(2,4))}"
        )
    }
}
