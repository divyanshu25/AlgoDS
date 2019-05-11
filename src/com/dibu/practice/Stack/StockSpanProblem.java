package com.dibu.practice.Stack;

import java.util.Stack;

public class StockSpanProblem {

    static int[] calculateSpan(int[] price){
        int[] span = new int[price.length];
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        span[0] = 1;
        for(int i = 1; i < price.length; i++){
            while(!st.empty() && price[st.peek()]<= price[i]){
                st.pop();
            }
            span[i] = st.empty()?i+1:i-st.peek();
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args){
        int[] price = {100,80,60,70,60,75,85};
        int[] span = calculateSpan(price);
        for(int i = 0 ; i< span.length; i++){
            System.out.print(span[i]+" ");
        }
    }
}
