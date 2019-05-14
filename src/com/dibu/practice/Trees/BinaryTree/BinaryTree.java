package com.dibu.practice.Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by divyanshugoyal on 5/11/19.
 */

class Node{
    int data;
    TreeNode right,left;
    Node(int data){
        this.data = data;
        this.right = this.left = null;
    }
}
public class BinaryTree {
    TreeNode root;
    BinaryTree(){
        this.root = null;
    }
    TreeNode insertHelper(TreeNode r, int data){
        if(r == null){
            r = new TreeNode(data);
        }else{
            if(data > r.data){
                r.right = insertHelper(r.right, data);
            }else{
                r.left = insertHelper(r.left,data);
            }
        }
        return r;
    }
    void insert(int data){
        root = insertHelper(this.root, data);
    }

    void inorderTraversalHepler(TreeNode r){
        if(r == null){
            return;
        }
        inorderTraversalHepler(r.left);
        System.out.print(r.data+ " ");
        inorderTraversalHepler(r.right);
    }
    void inorderTraversal(){
        inorderTraversalHepler(this.root);
        System.out.println();
    }

    void postorderTraversalHepler(TreeNode r){
        if(r == null){
            return;
        }
        postorderTraversalHepler(r.left);
        postorderTraversalHepler(r.right);
        System.out.print(r.data+ " ");

    }
    void postorderTraversal(){
        postorderTraversalHepler(this.root);
        System.out.println();
    }

    void preorderTraversalHepler(TreeNode r){
        if(r == null){
            return;
        }
        System.out.print(r.data+ " ");
        preorderTraversalHepler(r.left);
        preorderTraversalHepler(r.right);
    }
    void preorderTraversal(){
        preorderTraversalHepler(this.root);
        System.out.println();
    }

    void BFS(){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode e = q.poll();
            System.out.print(e.data+ " ");
            if(e.left!=null) q.add(e.left);
            if(e.right!=null) q.add(e.right);
        }
    }

}


