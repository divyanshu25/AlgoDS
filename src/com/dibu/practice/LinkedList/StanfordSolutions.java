package com.dibu.practice.LinkedList;

import sun.awt.image.ImageWatched;

import java.util.HashMap;

/**
 * Created by divyanshugoyal on 5/5/19.
 */
public class StanfordSolutions {

    void appendNode(LinkedList list, Node node){
        if(list.length == 0){
            list.head = node;
            node.next = null;
            list.length++;
            return;
        }
        Node n = list.head;
        while(n.next !=null){
            n = n.next;
        }
        n.next = node;
        node.next = null;
        list.length++;
    }

    int count(LinkedList list, int data){
        Node n = list.head;
        int num =0;
        while(n!= null){
            if(n.data == data){
                num++;
            }
            n= n.next;
        }
        return num;
    } // Problem1
    int GetNth(LinkedList list, int n){
        if(n >= list.length){
            return -1;
        }
        Node node = list.head;
        int t =0;
        while(t < n){
            node = node.next;
            t++;
        }
        return node.data;
    } // Problem2
    void deleteList(LinkedList list){
        list.head = null;
        list.length = 0;
    } //Problem 3
    int pop(LinkedList list){
        if(list.head == null){
            return -1;
        }
        int data = list.head.data;
        list.head = list.head.next;
        list.length --;
        return data;
    } // Problem 4
    void insertNth(LinkedList list, int data, int n){
        if(n > list.length){
            return ;
        }
        list.length++;
        Node node = new Node(data);
        if(n == 0){
            node.next = list.head;
            list.head = node;
            return;
        }
        Node prev = list.head;
        Node curr = list.head.next;
        int t=1;
        while(t < n){
            curr = curr.next;
            prev = prev.next;
            t++;
        }
        node.next = curr;
        prev.next = node;
    } // Problem 5
    void sortedInsert(LinkedList list, Node n){
        // Current length = 0
        if(list.length == 0){
            n.next=null;
            list.head = n;
            list.length++;
            return;
        }
        // current length =1
        if(list.length == 1){
            if(list.head.data > n.data){
                n.next = list.head;
                list.head = n;
            }else{
                list.head.next = n;
                n.next=null;

            }
            list.length++;
            return;
        }
        // insert in the start.
        if(list.head.data >= n.data){
            list.length++;
            n.next =list.head;
            list.head= n;
            return;
        }

        Node prev = list.head;
        Node curr = list.head.next;
        while(curr != null){
            if(prev.data <= n.data && curr.data > n.data){
                n.next = curr;
                prev.next = n;
                list.length++;
                return;
            }
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = n;
        list.length++;
    } //Problem 6
    void insertSort(LinkedList list){
        if(list.length == 0 || list.length == 1){
            return;
        }
        Node n = list.head;
        Node nxt = list.head.next;
        LinkedList result = new LinkedList();
        while(nxt!=null){
            n.next = null;
            sortedInsert(result, n);
            n = nxt;
            nxt = nxt.next;
        }
        sortedInsert(result,n);
        list.head = result.head;
        result.head =null;
    } // Problem 7
    void appendList(LinkedList a, LinkedList b){
        Node n = a.head;
        if(n == null){
            a.head = b.head;
            b.head = null;
            return;
        }
        while(n.next != null){
            n = n.next;
        }
        n.next = b.head;
        b.head = null;
    } // Problem 8
    void frontbackSplit(LinkedList list, LinkedList front, LinkedList back){
        if(list.length == 0) return;
        if(list.length == 1){
            front.head = list.head;
            list.head = null;
            front.length++;
            list.length = 0;
            return;
        }
        int middle = 0;
        if(list.length %2 ==0){
            middle = list.length /2;
        }else{
            middle = list.length/2 + 1;
        }
        Node n = list.head;
        int t = 1;
        while(t < middle){
            n = n.next;
            t++;
        }
        back.head = n.next;
        back.length = list.length - middle;
        n.next = null;
        front.head = list.head;
        front.length = middle;
        list.head = null;
        list.length = 0;

    } //Problem 9
    void removeDuplicates(LinkedList list){
        if(list.length == 0 || list.length == 1){
            return;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        Node prev = list.head;
        Node curr = list.head.next;
        hashMap.put(prev.data,1);
        while(curr != null){
            if(hashMap.containsKey(curr.data)){
                prev.next = curr.next;
                curr = curr.next;
            }else{
                hashMap.put(curr.data,1);
                prev = prev.next;
                curr =curr.next;
            }
        }
    } //Problem 10
    void moveNode(LinkedList a , LinkedList b){
        if(b.length == 0){
            return;
        }
        Node n = b.head;
        b.head = b.head.next;
        n.next = a.head;
        a.head = n;
        a.length++;
        b.length--;
    } //Problem 11
    void alternatingSplit(LinkedList list, LinkedList a, LinkedList b){
        while(list.length !=0){
            moveNode(a, list);
            moveNode(b, list);
        }
    } //Problem 12
    void shuffleMerge(LinkedList list, LinkedList a, LinkedList b){
        while(a.head!=null && b.head!=null){
            if(a.head == null && b.head!= null){
                moveNode(list, b);
            }else if(a.head != null && b.head == null){
                moveNode(list,b);
            }else{
                moveNode(list,a);
                moveNode(list,b);
            }
        }
    } //Problem13
    void sortedMerge(LinkedList list, LinkedList a, LinkedList b){
        if(a.length == 0){
            list.head = b.head;
            list.length = b.length;
            return;
        }
        if(b.length == 0){
            list.head = a.head;
            list.length = b.length;
            return;
        }
        Node n1 = a.head;
        Node n2 =b.head;
        while(n1!=null || n2!=null){
            if(n2 == null){
                Node t = n1;
                n1 = n1.next;
                appendNode(list,t);
            }else if(n1 == null){
                Node t = n2;
                n2 = n2.next;
                appendNode(list, t);
            }else{
                Node t;
                if(n1.data > n2.data){
                    t = n2;
                    n2 = n2.next;
                    appendNode(list, t);
                }else{
                    t = n1;
                    n1 = n1.next;
                    appendNode(list, t);
                }
            }
        }
    } //Problem14
    void mergeSort(LinkedList list){
        if(list.length == 0 || list.length == 1){
            return;
        }
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        frontbackSplit(list,a,b);
        mergeSort(a);
        mergeSort(b);
        sortedMerge(list,a,b);
    } //Problem15
    void sortedIntersect(LinkedList list, LinkedList a, LinkedList b){
        Node n1 = a.head;
        Node n2 = b.head;
        while(n1 != null && n2 != null){
            if(n1.data == n2.data){
                appendNode(list, new Node(n1.data));
                n1 = n1.next;
                n2=n2.next;
            }else if(n1.data > n2.data){
                n2 = n2.next;
            }else{
                n1=n1.next;
            }
        }
    } //Problem16
    Node reverseListFunc(Node n, LinkedList rev){
        if(n.next == null){
            rev.head = n;
            n.next = null;
            return n;
        }
        Node prev = reverseListFunc(n.next, rev);
        prev.next = n;
        n.next = null;
        return n;


    } //Problem17
    void reverse(LinkedList list){
        if(list.length == 0 || list.length == 1){
            return;
        }
        LinkedList revList = new LinkedList();
        Node n =reverseListFunc(list.head, revList);
        n.next = null;
        list.head = revList.head;
        list.printList();
    }//Problem17

}
