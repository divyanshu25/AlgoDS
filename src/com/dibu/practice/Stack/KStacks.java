package com.dibu.practice.Stack;

/**
 * Created by divyanshugoyal on 5/5/19.
 */
public class KStacks {
    int[] arr;
    int[] first;
    int[] next;
    int[] last;
    int curr;
    int size;
    KStacks(int size,int k){
        this.size = 0;
        arr= new int[size];
        first = new int[k];
        last = new int[k];
        next = new int[size];
        for(int i = 0 ; i < size ; i++){
            first[i] = -1;
            last[i] = -1;
            next[i] = -1;
        }
    }
    void push(int data, int k){
        if(curr >= )
        if(first[k] == -1){

        }
    }

}
