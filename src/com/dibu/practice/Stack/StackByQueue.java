package com.dibu.practice.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by divyanshugoyal on 5/5/19.
 */
public class StackByQueue {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    void push(int x){
        q2.add(x);
        while(! q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> q = q1;
        q1= q2;
        q2 = q;
    }
    int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        return q1.remove();
    }
    public static void main(String[] args){
        StackByQueue s = new StackByQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }


}
