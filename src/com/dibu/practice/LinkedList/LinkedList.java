package com.dibu.practice.LinkedList;


public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        LinkedList linkedList= new LinkedList();
        linkedList.head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);

        linkedList.head.next=node1;
        node1.next=node2;
    }
}
