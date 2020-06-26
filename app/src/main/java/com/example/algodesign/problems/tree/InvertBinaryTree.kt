package com.example.algodesign.problems.tree

import com.example.algodesign.utils.ProblemInterface

// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/

class InvertBinaryTree : ProblemInterface {


    private fun preOrder(root: TreeNode) {
        preOrderUtils(root)
    }

    private fun preOrderUtils(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        preOrderUtils(root.left)
        preOrderUtils(root.right)
        val temp = root.right
        root.right = root.left
        root.left = temp

        return root
    }


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    override fun execute() {
        val root = TreeNode(4)
        root.left = TreeNode(2)
        root.right = TreeNode(7)
        root.left!!.left = TreeNode(1)
        root.right!!.right = TreeNode(3)
        root.right!!.left = TreeNode(6)
        root.right!!.right = TreeNode(9)

        preOrder(root)

    }
}