package com.dibu.practice.Stack;

import java.util.Stack;

public class NextGreaterElement {

    public static int[] getNextElement(int[] val){
        if(val.length == 1 ||  val.length == 0){
            return new int[]{-1};
        }
        int[] nexVal = new int[val.length];
        for(int i = 0 ; i< nexVal.length ; i++){
            nexVal[i] = -1;
        }
        Stack<Integer> st = new Stack<Integer>();
        st.push(val.length - 1);
        for(int i = val.length - 2; i>=0 ; i--){
            while(!st.empty() && val[st.peek()]<= val[i]){
                st.pop();
            }
            nexVal[i] = st.empty()?-1:val[st.peek()];
            st.push(i);
        }
        return nexVal;
    }
    public static void main(String[] args){
        int[] val = {4,5,2,25};
        int[] ans = getNextElement(val);
        for(int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
