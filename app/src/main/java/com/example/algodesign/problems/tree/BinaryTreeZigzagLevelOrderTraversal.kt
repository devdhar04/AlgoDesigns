package com.example.algodesign.problems.tree

import com.example.algodesign.utils.ProblemInterface
import java.util.*

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        var level = 0
        while (!q.isEmpty()) {
            val length = q.size
            level++
            val levelList = mutableListOf<Int>()
            for (i in 0 until length) {

                    if (q.peek().left != null) {
                        q.offer(q.peek().left)
                    }
                    if (q.peek().right != null) {
                        q.offer(q.peek().right)
                    }
                if(level %2 == 0){
                    levelList.add(0,q.poll().`val`)
                }else{
                    levelList.add(q.poll().`val`)
                }

            }
            list.add(levelList)
        }
        return list
    }

    override fun execute() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right!!.left = TreeNode(15)
        root.right!!.right = TreeNode(7)

       val list =  zigzagLevelOrder(root)
    }
}
