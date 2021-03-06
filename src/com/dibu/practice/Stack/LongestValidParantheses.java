package com.dibu.practice.Stack;

import java.util.Stack;

public class LongestValidParantheses {

    public static int longestValidParentheses(String s) {
        if(s.length() <=1){
            return 0;
        }
        int maxLen = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        for(int i =0; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.empty()){
                    st.push(i);
                }else {
                    int l = i - st.peek();
                    if (l > maxLen) {
                        maxLen = l;
                    }
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        String s= "(((((";
        System.out.println(longestValidParentheses(s));
    }
}
