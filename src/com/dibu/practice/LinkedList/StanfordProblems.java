package com.dibu.practice.LinkedList;

import sun.awt.image.ImageWatched;

import javax.sound.sampled.Line;

/**
 * Created by divyanshugoyal on 5/4/19.
 */
public class StanfordProblems {
    public static void main(String[] args){
        //============Problem 1 to 8 ===================//
        LinkedList linkedList = new LinkedList();
        StanfordSolutions s = new StanfordSolutions();
        LinkedList linkedList1 = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(1);
        linkedList.append(2);
        System.out.println(s.count(linkedList, 1));
        System.out.println(s.GetNth(linkedList, 2));
        s.insertNth(linkedList,6,5);
        linkedList.printList();
//        s.sortedInsert(linkedList,new Node(3));
//        linkedList.printList();
        s.insertSort(linkedList);
        linkedList.printList();

        linkedList1.append(5);
        linkedList1.append(6);
        linkedList1.append(7);
        linkedList1.append(8);
        linkedList1.append(6);
//
        s.appendList(linkedList, linkedList1);
        linkedList.printList();
        //============================================================//
        //===============Problem 9 - ================================//
        System.out.println("9 Onwards");
        LinkedList a  = new LinkedList();
        LinkedList b = new LinkedList();
        LinkedList l =  new LinkedList();
        a.append(1);
        a.append(2);
        a.append(3);
        a.append(4);

        b.append(5);
        b.append(6);
        b.append(6);
        b.append(7);
//        a.printList();
//        s.mergeSort(a);
//        a.printList();
        s.sortedIntersect(l, a ,b);
        l.printList();
        s.reverse(b);

//
    }
}
