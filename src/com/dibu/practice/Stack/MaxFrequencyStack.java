package com.dibu.practice.Stack;
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.PQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by divyanshugoyal on 5/10/19.
 */
class MaxFrequencyStack {
    int numE = 0;
    PriorityQueue<Entry> q;
    Map<Integer,Integer> m;

    class Entry{
        int data;
        int freq;
        int pos;
        Entry(int data, int freq, int pos){
            this.data = data;
            this. freq = freq;
            this.pos = pos;
        }
        void print(){
            System.out.println(this.data + " "+ this.freq + " "+ this.pos);
        }
    }

    class EntryComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry e1, Entry e2){
            if(e1.freq < e2.freq){
                return 1;
            }
            else if(e1.freq == e2.freq){
                if(e1.pos < e2.pos){
                    return 1;
                }
            }
            return -1;
        }
    }

    public MaxFrequencyStack() {
        q = new PriorityQueue<Entry>(150000, new EntryComparator());
        m = new HashMap<Integer, Integer>();
    }


    public void push(int x) {
        numE++;
        if(m.containsKey(x)){
            m.put(x, m.get(x)+1);
        }else{
            m.put(x,1);
        }
        Entry e =new Entry(x, m.get(x),numE);
        q.add(e);
    }

    public int pop() {
        Entry e = q.poll();
        if(m.get(e.data) <= 1){
            m.remove(e.data);
        }else{
            m.put(e.data, m.get(e.data)-1);
        }
        return e.data;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
