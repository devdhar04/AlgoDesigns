package com.example.algodesign.problems.tree

import android.util.Log
import com.example.algodesign.utils.ProblemInterface

class CousinsInBinaryTree : ProblemInterface {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    var xHeight = -1
    var yHeight = -1
    var xParentNode : TreeNode? = null
    var yParentNode : TreeNode? = null

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {

        var height = 0
        searchInBST(root,null,height,x,y)
        if(xHeight == yHeight && xParentNode?.`val` != yParentNode?.`val`){
            return true
        }

        return false
    }

    private fun searchInBST(node : TreeNode?,parentNode: TreeNode?,height : Int,x: Int,y: Int){
        if(node == null){
            return
        }
        Log.v("searchInBST","searchInBST ${node.`val`} height ${height}")
        if(node.`val` == x){
            xHeight = height
            xParentNode = parentNode
        }
        else if(node.`val` == y){
            yHeight = height
            yParentNode = parentNode
        }
        searchInBST(node.left,node,height+1,x,y)
        searchInBST(node.right,node,height+1,x,y)
    }



    override fun execute() {
        val ti = TreeNode(1)
        ti.left = TreeNode(2)
        ti.right = TreeNode(3)
        ti.left!!.right = TreeNode(4)
        ti.right!!.right = TreeNode(5)

        isCousins(ti,5,4)

    }
}
