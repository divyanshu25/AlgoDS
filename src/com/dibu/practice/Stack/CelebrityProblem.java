package com.dibu.practice.Stack;

import java.util.ArrayList;
import java.util.Arrays;

public class CelebrityProblem {
    static int MATRIX[][] = {
            { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 }
    };

    public static boolean doesAKnowsB(int A, int B){
        if(MATRIX[A][B] == 1){
            return true;
        }
        return false;
    }
    public static boolean checkCelebrity(int a, int n){
        int inDegree = 0;
        for(int i = 0 ; i < n ; i++){
            if(i!=a && doesAKnowsB(i,a) && !doesAKnowsB(a,i)){
                inDegree++;
            }
        }
        if(inDegree == n-1){
            return true;
        }
        return false;
    }
    public static boolean isCelebrityPresent(int n){
        if(n ==0 || n== 1){
            return false;
        }
        int a = 0;
        int b = 1;
        if(n==2){
            boolean ab = doesAKnowsB(a,b);
            boolean ba = doesAKnowsB(b,a);
            if(ab == !ba ){
                return true;
            }
            return false;
        }
        while((a < n) && (b < n)){
            System.out.println(a+ " " + b);
            boolean ab = doesAKnowsB(a,b);
            if(ab){
                a = Math.max(a,b)+1;
            }
            else{
                b = Math.max(a,b)+1;
            }
        }
        if(a == n){
            return checkCelebrity(b, n);
        }else{
            checkCelebrity(a, n);
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(isCelebrityPresent(n));
    }
}
