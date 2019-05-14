package com.dibu.practice.Stack;

import java.util.Stack;

/**
 * Created by divyanshugoyal on 5/9/19.
 */
public class ValidateSequence {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length ==0){
            return true;
        }
        boolean ans = true;
        Stack<Integer> st = new Stack<Integer>();
        int ptr = 0;
        for(int i=0 ; i < pushed.length ; i++){
            st.push(pushed[i]);
            while(!st.empty() && ptr<popped.length && st.peek() == popped[ptr]){
                st.pop();
                ptr++;
            }
        }
        return st.empty()?true:false;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,0};
        int[] popped = new int[]{1,0};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
