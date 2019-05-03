package com.dibu.practice.LinkedList;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    int length;
    LinkedList(){
        head = null;
        length = 0;
    }
    void printList(){
        Node p = this.head;
        while(p != null){
            System.out.print(p.data + "->");
            p =p.next;
        }
        System.out.println("null");
    }
    void push(int data){
        this.length++;
        if(this.head == null){
            this.head = new Node(data);
            return;
        }
        Node n= new Node(data);
        n.next = this.head;
        this.head = n;
    }
    void append(int data){
        this.length++;
        if(this.head == null){
            push(data);
            return;
        }
        Node n = new Node(data);
        Node tmp = this.head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = n;
    }
    void insert(int data, int index){
        if(index >= this.length){
            append(data);
        }else if(index == 0){
            push(data);
        }else{
            int t = 1;
            Node tmp = this.head;
            Node n = new Node(data);
            while(t < index){
                tmp = tmp.next;
                t++;
            }
            n.next = tmp.next;
            tmp.next = n;
            this.length++;

        }
    }
    void deleteAtIndex(int index) {
        if (this.length == 0 || index >= this.length) {
            return;
        }
        if (index == 0) {
            this.head = this.head.next;
        } else {
            int t = 1;
            Node tmp = this.head;
            while (t < index) {
                tmp = tmp.next;
                t++;
            }
            tmp.next = tmp.next.next;

        }
        this.length--;
    }
    void delete(int data){
        if(this.length == 0){
            return;
        }
        if(this.length == 1){
            if(this.head.data == data){
                this.head = null;
                this.length--;
            }
            return;
        }
        Node tmp = this.head;
        Node prev = null;
        while(tmp !=null){
            if(tmp.data == data){
                if(prev != null) {
                    prev.next = tmp.next;
                    this.length--;
                }else{
                    this.head = tmp.next;
                }
                return;
            }
            prev = tmp;
            tmp=tmp.next;
        }
    }
}
public class LinkedListMain {
    public static void main(String[] args){
        LinkedList linkedList= new LinkedList();
        linkedList.push(5);
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(1);
        linkedList.insert(9,6);
        linkedList.deleteAtIndex(1);
        linkedList.delete(2);
        linkedList.printList();
    }
}
