package com.dibu.practice.Stack;

/**
 * Created by divyanshugoyal on 5/5/19.
 */
public class TwoStacks {
    private int[] arr;
    private int p1;
    private int p2;
    private int size;
    TwoStacks(int size){
        arr = new int[size];
        this.size = size;
        p1 = -1;
        p2 = size;
    }

    void push1(int x){
        if(p1 <= size-1 && p2-p1 > 1 ){
            p1++;
            arr[p1] = x;
        }else{
            System.out.println("Stack is full");
        }
    }
    void push2(int x){
        if(p2 >= 0 && p2 - p1 > 1){
            p2--;
            arr[p2] = x;
        }else{
            System.out.println("Stack is full");
        }
    }
    int pop1(){
        if(p1 ==-1){
            return -1;
        }
        int top = arr[p1];
        p1--;
        return top;
    }
    int pop2(){
        if(p2 == size){
            return -1;
        }
        int top = arr[p2];
        p2++;
        return top;
    }
    void print(){
        for(int i=0 ; i< size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        TwoStacks t = new TwoStacks(5);
        t.push1(1);
        t.print();

        t.push1(2);
        t.print();

        t.push1(3);
        t.print();

        t.push2(1);
        t.print();

        t.push2(2);
        t.print();

        t.pop2();
        t.push1(4);
        t.print();

        t.pop2();
        t.push1(5);
        t.print();

        t.pop1();
        t.push2(7);
        t.print();


    }
}
