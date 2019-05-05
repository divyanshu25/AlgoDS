package com.dibu.practice.LinkedList;

import apple.laf.JRSUIUtils;

/**
 * Created by divyanshugoyal on 5/5/19.
 */


class TreeNode{
    int data;
    TreeNode small;
    TreeNode large;
    TreeNode(int data){
        this.data = data;
        this.small = null;
        this.large = null;
    }
}
class Tree{
    TreeNode root;
    void insertRecurse(TreeNode r, TreeNode n){
        if(n.data <= r.data){
            if(r.small == null){
                r.small = n;
            }else{
                insertRecurse(r.small , n);
            }
        }else{
            if(r.large == null){
                r.large = n;
            }else{
                insertRecurse(r.large, n);
            }
        }
    }
    void insert(int data){
        TreeNode n = new TreeNode(data);
        if(this.root == null){
            root = n;
            return;
        }
        insertRecurse(this.root, n);

    }
    void printTreeRecurse(TreeNode r){
        if(r == null){
            return;
        }
        printTreeRecurse(r.small);
        System.out.println(r.data + " ");
        printTreeRecurse(r.large);
    }
    void printTree(){
        if(this.root == null){
            return;
        }
        printTreeRecurse(root);
    }
    TreeNode getLinkedListHelper(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode prev = getLinkedListHelper(root.small);
        TreeNode next = getLinkedListHelper(root.large);

        if(prev == null && next == null){
            root.small = root;
            root.large = root;
            return root;
        }else if(prev != null && next == null){
            TreeNode last = prev;
            while(last.large != prev){
                last = last.large;
            }
            last.large = root;
            root.large = prev;
            prev.small = root;
            root.small = last;
            return prev;
        }else if(prev == null && next != null){
            TreeNode last = next;
            while(last.large != next){
                last = last.large;
            }
            last.large = root;
            root.small = last;
            root.large = next;
            next.small = root;
            return root;
        }else{
            TreeNode lastPrev = prev;
            TreeNode lastNext = next;
            while(lastPrev.large != prev){
                lastPrev = lastPrev.large;
            }
            while(lastNext.large != next){
                lastNext = lastNext.large;
            }

            lastPrev.large = root;
            root.large = next;
            lastNext.large = prev;
            next.small = root;
            root.small = lastPrev;
            prev.small = lastNext;
            return prev;
        }

    }
    TreeNode getLinkedList(){
        return getLinkedListHelper(this.root);
    }

}
public class GreatTreeRecursionProblem {

    public static void printLinkedList(TreeNode root){
        TreeNode itr = root;
        while(itr.large!= root){
            System.out.print(itr.data + " ");
            itr= itr.large;
        }
        System.out.println(itr.data);

    }
    public static void main(String[] args){
        Tree t = new Tree();
        t.insert(4);
        t.insert(2);
        t.insert(3);
        t.insert(5);
        t.insert(6);
        t.printTree();
        TreeNode root = t.getLinkedList();
        printLinkedList(root);
    }
}
