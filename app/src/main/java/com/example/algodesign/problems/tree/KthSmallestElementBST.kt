package com.example.algodesign.problems.tree

import android.util.Log
import com.example.algodesign.utils.ProblemInterface
import java.util.*

class KthSmallestElementBST : ProblemInterface {


    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val result = inOrder(root,mutableListOf())
        return result[k-1]
    }

    private fun inOrder(node: TreeNode?, list:MutableList<Int>): List<Int>{
        if(node == null)
            return list

        inOrder(node.left,list)
        list.add(node.`val`)
        inOrder(node.right,list)

        return list
    }


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    override fun execute() {
        val root = TreeNode(5)
        root.left = TreeNode(3)
        root.right = TreeNode(6)
        root.left!!.left = TreeNode(2)
        root.left!!.right = TreeNode(4)
        root.left!!.left!!.left = TreeNode(1)

        kthSmallest(root, 3)

        Log.v("kthSmallest", "kthSmallest ${kthSmallest(root, 3)}")

    }
}
