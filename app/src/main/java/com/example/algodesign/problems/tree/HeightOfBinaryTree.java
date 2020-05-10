package com.example.algodesign.problems.tree;

import com.example.algodesign.utils.ProblemInterface;

/*
https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
 */
public class HeightOfBinaryTree implements ProblemInterface {

    public int height(Node root) {
        return heightUtils(root, 0) - 1;
    }

    private int heightUtils(Node root, int height) {
        if (root == null) {
            return height;
        }
        return Math.max(heightUtils(root.left, height + 1), heightUtils(root.right, height + 1));
    }

    private void preOrder(Node root){

        preOrderUtils(root);
    }

    private void preOrderUtils(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrderUtils(root.left);
            preOrderUtils(root.right);
        }

    }


    class Node {
        public Node(int data) {
            this.data = data;
        }

        int data;
        Node left;
        Node right;
    }



    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    @Override
    public void execute() {

    }

}
