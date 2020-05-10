package com.example.algodesign.problems.tree;

import android.util.Log;

import com.example.algodesign.utils.ProblemInterface;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree implements ProblemInterface {


    public static void topView(Node root) {

        Map<Integer, Integer> map = topViewSolution(root);

        for (Integer data : map.values()) {
            System.out.print(data + " ");
            Log.v("Data","Data "+data);
        }
    }

    private static void levelOrder(Node root) {
        if (root == null) {
            return ;
        }
        Node node;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            node = q.peek();
            q.remove();
            System.out.print(node.data+" ");

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }



    private static Map<Integer, Integer> topViewSolution(Node root) {
        if (root == null) {
            return null;
        }
        Node node = null;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            node = q.peek().first;
            int distance = q.peek().second;
            q.remove();
            if (!treeMap.containsKey(distance)) {
                treeMap.put(distance, node.data);
            }
            if (node.left != null) {
                q.add(new Pair(node.left, distance -1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, distance + 1));
            }
        }
        return treeMap;
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

    static class Pair<T,V> {
        T first;
        V second;

        public Pair(T node, V data) {
            this.first = node;
            this.second = data;
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

    @Override
    public void execute() {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(6);
        root.right.right.left.right = new Node(4);
        topView(root);
    }
}
