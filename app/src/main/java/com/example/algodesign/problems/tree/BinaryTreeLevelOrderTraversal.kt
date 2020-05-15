package com.example.algodesign.problems.tree

import com.example.algodesign.utils.ProblemInterface
import java.util.*

//https://leetcode.com/problems/binary-tree-level-order-traversal/
class BinaryTreeLevelOrderTraversal : ProblemInterface {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        return levelOrderTraversal(root)
    }

    private fun levelOrderTraversal(root: TreeNode?): MutableList<List<Int>> {
        val list: MutableList<List<Int>> =
            ArrayList()
        if (root == null) {
            return list
        }
        var node: TreeNode
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        var rootList = mutableListOf(root.`val`)
        list.add(rootList)
        while (!q.isEmpty()) {
            node = q.peek()
            q.remove()
            rootList = ArrayList<Int>()
            if (node.left != null) {
                q.add(node.left)
                val data = node.left
                rootList.add(data!!.`val`)
            }
            if (node.right != null) {
                q.add(node.right)
                val data = node.right
                rootList.add(data!!.`val`)
            }
            if (rootList.isNotEmpty()) {
                list.add(rootList)
            }
        }
        return list
    }


    override fun execute() {


    }
}
