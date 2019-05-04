package com.dibu.practice.LinkedList;


import java.util.Arrays;
import java.util.Stack;

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
        this.length++;
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
    int lengthRecursive(Node head){
        if(head == null){
            return 0;
        }
        return 1+ lengthRecursive(head.next);
    }
    int lengthInterative(Node head){
        Node n = head;
        int len =0;
        while(n != null){
            n = n.next;
            len++;
        }
        return len;
    }
    boolean findRecurcive(Node head, int data){
        if(head == null){
            return false;
        }
        if(head.data == data){
            return true;
        }
        return findRecurcive(head.next, data);
    }
    boolean findIterative(Node head, int data){
        Node n = head;
        while(n!= null){
            if(n.data == data){
                return true;
            }
            n=n.next;
        }
        return false;
    }
    int nthElementFromLast(int n){
        if(n > this.length || n==0){
            return -1;
        }
        int index = this.length - n;
        Node node = this.head;
        int t = 0;
        while(t < index){
            node = node.next;
            t++;
        }
        return node.data;
    }
    int elementAtIndexN(int n){
        if(n >= this.length){
            return -1;
        }
        Node node = this.head;
        int t = 0;
        while(t < n){
            node = node.next;
            t++;
        }
        return node.data;

    }
    int[] middleElement(){
        if((this.length)%2 ==0){
            int middle1 = this.length/2 -1 ;
            int middle2 = middle1+1;
            int m1 = elementAtIndexN(middle1);
            int m2 = elementAtIndexN(middle2);
            return new int[]{m1,m2};
        }else{
            int middle = this.length/2;
            int m1 = elementAtIndexN(middle);
            return new int[]{m1};
        }
    }
    boolean detectLoop(){
        Node fp = this.head;
        Node sp = this.head;
        while(fp!=null && sp!= null && fp.next!=null){
            sp = sp.next;
            fp = fp.next.next;
            if(fp == sp){
                return true;
            }
        }
        return false;
    }
    int lenLoop(){
        Node sp = this.head;
        Node fp =this.head;
        while(sp != null && fp!=null && fp.next !=null){
            sp = sp.next;
            fp = fp.next.next;
            if(sp == fp){
                int len = 1;
                fp = fp.next;
                while(fp != sp){
                    fp = fp.next;
                    len++;
                }
                return len;
            }
        }
        return 0;
    }
    Node reverseListFunc(Node head, LinkedList list){
        if(head.next == null) {
            Node newhead;
            newhead = head;
            list.head = newhead;
            return newhead;
        }
        Node n = reverseListFunc(head.next,list);
        n.next = head;
        return n.next;
    }
    LinkedList reverseList(){
        LinkedList revList = new LinkedList();
        Node n = reverseListFunc(this.head, revList);
        n.next = null;
        return revList;

    }
    boolean isPalindrome(){
        if(this.length ==0 || this.length == 1){
            return true;
        }
        Node n = this.head;
        int middle = 0;
        if(this.length%2 == 0){
            middle = this.length / 2;
        }else{
            middle = (this.length / 2)+1;
        }
        int t = 1;
        while(t < middle){
            n = n.next;
            t++;
        }
        LinkedList half = new LinkedList();
        half.head = n.next;
        n.next=null;
        half.length = this.length - middle;
        half.printList();
        LinkedList revHalf = half.reverseList();
        revHalf.printList();
        Node n1 = revHalf.head;
        Node n2 = this.head;
        boolean flag = true;
        while(n1 != null){
            if(n1.data != n2.data){
                flag = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return flag;
    }
    boolean isPalindromeStack(){
        Node n = this.head;
        Stack<Integer> st = new Stack<Integer>();
        while(n != null){
            st.push(n.data);
            n = n.next;
        }
        n = this.head;
        while(n != null){
            if(n.data == st.peek()){
                st.pop();
            }
            n= n.next;
        }
        if(st.empty()){
            return true;
        }
        return false;
    }
}
public class LinkedListMain {
    public static void main(String[] args){
        LinkedList linkedList= new LinkedList();
        LinkedList linkedList1 = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        //=============================================================//
        linkedList.push(6);
        linkedList.push(5);
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(1);
        linkedList.insert(9,6);
        linkedList.deleteAtIndex(1);
        linkedList.delete(2);
        linkedList.printList();
        System.out.println(linkedList.lengthRecursive(linkedList.head));
        System.out.println(linkedList.lengthInterative(linkedList.head));
        System.out.println(linkedList.findRecurcive(linkedList.head, 12));
        System.out.println(linkedList.findIterative(linkedList.head, 9));
        System.out.println(linkedList.nthElementFromLast(0));
        System.out.println(Arrays.toString(linkedList.middleElement()));
        //=============================================================//
        linkedList1.push(1);
        linkedList1.push(2);
        linkedList1.push(3);
        linkedList1.push(4);
        linkedList1.push(5);
        linkedList1.push(6);
        linkedList1.printList();
        linkedList1.head.next.next.next.next.next.next = linkedList1.head.next;
        System.out.println(linkedList1.detectLoop());
        System.out.println(linkedList1.lenLoop());
        //=============================================================//
        linkedList2.append(1);
        linkedList2.append(2);
        linkedList2.append(3);
        linkedList2.append(2);
        linkedList2.append(1);
        linkedList2.printList();
//        LinkedList revList = linkedList2.reverseList();
//        revList.printList();

        System.out.println(linkedList2.isPalindromeStack());
    }
}
