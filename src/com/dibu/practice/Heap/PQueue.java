package com.dibu.practice.Heap;


import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 * Created by divyanshugoyal on 5/10/19.
 */
public class PQueue {
    PriorityQueue<Integer> q;

    PQueue(){
        q = new PriorityQueue<Integer>(100, new sort());
    }

    class sort implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b) {
            if (a < b) return 1;
            return -1;
        }
    }

    public static void main(String[] args) {
        PQueue p = new PQueue();
        p.q.add(1);
        p.q.add(2);
        p.q.add(3);
        p.q.add(4);
        p.q.add(5);
        p.q.add(6);
        p.q.add(7);



        Iterator itr = p.q.iterator();
        while(!p.q.isEmpty()){
            System.out.println(p.q.poll());
        }
    }
}
