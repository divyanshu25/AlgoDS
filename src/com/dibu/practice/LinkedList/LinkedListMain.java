package com.dibu.practice.LinkedList;


import java.util.Arrays;
import java.util.Stack;

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
