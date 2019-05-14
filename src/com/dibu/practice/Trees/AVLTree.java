package com.dibu.practice.Trees;

class Node{
    int data, height;
    Node left, right;
    Node(int data){
        this.data = data;
        this.height =1;
        this.right = this.left = null;
    }
}

public class AVLTree {
    Node root;
    AVLTree(){
        root = null;
    }
    void print(Node n){
        if(n==null){
            return;
        }
        print(n.left);
        System.out.print(n.data+ " ");
        print(n.right);
    }
    Node RightRotate(Node n){
        Node temp = n.left.right;
        Node left = n.left;
        n.left = temp;
        left.right = n;
        int rightHeight = (n.right == null)?0:n.right.height;
        int leftHeight = (temp == null)?0:temp.height;
        n.height = Math.max(leftHeight, rightHeight)+1;
        return left;
    }

    Node LeftRotate(Node n){
        Node temp = n.right.left;
        Node right = n.right;
        n.right = temp;
        right.left = n;
        int rightHeight = (temp == null)?0:temp.height;
        int leftHeight = (n.left == null)?0:n.left.height;
        n.height = Math.max(leftHeight, rightHeight)+1;
        return right;
    }


    Node insertHelper(Node n, int data){
        if(n == null){
            return new Node(data);
        }
        else if(data > n.data){
            n.right = insertHelper(n.right, data);
        }else{
            n.left = insertHelper(n.left, data);
        }
        int leftHeight = (n.left!=null)?n.left.height:0;
        int rightHeight = (n.right!=null)?n.right.height:0;
        if(Math.abs(leftHeight - rightHeight)>1) {
            System.out.println("IsImbalanced "+ n.data);
            if(leftHeight > rightHeight){
                if(data < n.left.data){
                    // left left
                    n = RightRotate(n);
                }else{
                    n.left = LeftRotate(n.left);
                    n= RightRotate(n);
                    //left right
                }
            }else{
                if(data > n.right.data){
                    // right right
                    n = LeftRotate(n);
                }else{
                    // right left
                    n.right = RightRotate(n.right);
                    n = LeftRotate(n);

                }
            }
        }
        leftHeight = (n.left!=null)?n.left.height:0;
        rightHeight = (n.right!=null)?n.right.height:0;
        n.height = Math.max(leftHeight, rightHeight) + 1;

        return n;
    }
    void insert(int data){
        root = insertHelper(root, data);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(6);
        avlTree.insert(12);
        avlTree.insert(5);
        avlTree.insert(7);
        avlTree.insert(8);
//        avlTree.insert(9);
//        avlTree.insert(3);
//        avlTree.insert(2);
        avlTree.print(avlTree.root);
    }

}
