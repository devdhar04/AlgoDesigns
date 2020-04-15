package com.example.algodesign.problems.tree

import android.util.Log
import com.example.algodesign.problems.ProblemInterface
import kotlin.math.max
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
class BinaryTreeDiameter : ProblemInterface{

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     *
     *   1
        / \
       2   3
      / \
     4   5
     *
     */

    class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
         }
    //PreOrder traversal
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if(root == null)
            return 0
        val result = height(root.left) + height(root.right)
    return max(result, max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)))
    }

    private fun height(node: TreeNode?) : Int{
        if(node == null){
            return 0
        }
        val leftHeight = height(node.left)
        val rightsHeight = height(node.right)
        return  max(leftHeight,rightsHeight)+1
    }


    override fun execute() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(3)
        tree.left!!.left  = TreeNode(4)
        tree.left!!.right  = TreeNode(5)
        val  height = diameterOfBinaryTree(tree)
        Log.v("height","height ${height}")
    }
}
