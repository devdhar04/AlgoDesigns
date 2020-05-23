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
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)

        while (!q.isEmpty()) {
            val length = q.size
            val levelList = mutableListOf<Int>()
            for (i in 0 until length) {

                if (q.peek().left != null) {
                    q.offer(q.peek().left)

                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right)
                }
                levelList.add(q.poll().`val`)
            }
            list.add(levelList)
        }
        return list
    }


    override fun execute() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left!!.left = TreeNode(4)
        root.right!!.right = TreeNode(5)

        val list = levelOrder(root)

    }
}
