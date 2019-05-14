package com.dibu.practice.Trees.BinaryTree;

/**
 * Created by divyanshugoyal on 5/11/19.
 */
public class BinaryTreeTester {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(3);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);
        tree.BFS();
        System.out.println();
        tree.inorderTraversal();
        System.out.println();
        tree.preorderTraversal();
        System.out.println();
        tree.postorderTraversal();

    }
}
