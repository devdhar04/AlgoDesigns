package com.example.algodesign.problems.design

import com.example.algodesign.utils.ProblemInterface

class Trie : ProblemInterface {

    private val root = Node(0.toChar())

    inner class Node(val char: Char) {
        val map = HashMap<Char, Node>()
        var isWorldEnd = false
    }


    fun insert(word: String) {
        if (word.isNotEmpty()) {
          insertNode(root,word,0)
        }
    }

    private fun insertNode(node: Node, word: String, i: Int) {
        val index = i
        if (index < word.length) {
            val char =  word.elementAt(i)
            if (node.map.containsKey(char)) {
                val child = node.map[char]
                insertNode(child!!,word,index+1)
            } else {
                node.map[char] = Node(char)
                insertNode(node.map[char]!!,word,index+1)
            }
        }
        else{
            node.isWorldEnd = true
        }
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        if(word.isNotEmpty()){
            var index = 0
            var node  = root
            while (index < word.length){
                val char = word.elementAt(index)
                if(node.map.containsKey(char)){
                    node = node.map[char]!!
                    index++
                }
                else{
                    return false
                }
            }

            if(node.isWorldEnd){
                return true
            }
        }
        return false
    }

    private fun searchPrefix(word: String) : Boolean{
        if(word.isNotEmpty()){
            var index = 0
            var node  = root
            while (index < word.length){
                val char = word.elementAt(index)
                if(node.map.containsKey(char)){
                    node = node.map[char]!!
                    index++
                }
                else{
                    return false
                }
            }
        }
        return true
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        return searchPrefix(prefix)
    }

    override fun execute() {
     val trie = Trie()
        trie.insert("abcd")

    }
}
