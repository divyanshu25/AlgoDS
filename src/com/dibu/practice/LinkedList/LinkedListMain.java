package com.dibu.practice.LinkedList;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

class LinkedList{
    Node head;

    public void printList(){
        Node node = this.head;
        while(node!= null){
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}

public class LinkedListMain {

    public static void main(String[] args){
        LinkedList linkedList= new LinkedList();
        linkedList.head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        linkedList.head.next=node1;
        node1.next=node2;
        linkedList.printList();
    }
}
