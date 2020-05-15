package com.example.algodesign.problems.tree

import com.example.algodesign.utils.ProblemInterface
import java.util.*

class BinaryTreeZigzagLevelOrderTraversal : ProblemInterface {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        return levelOrderTraversal(root)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
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

            if(rootList.size%2 == 0) {

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
            }
            if (rootList.isNotEmpty()) {
                list.add(rootList)
            }
        }
        return list
    }

    override fun execute() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left!!.left = TreeNode(4)
        root.right!!.right = TreeNode(5)

       val lis =  zigzagLevelOrder(root)
    }
}
