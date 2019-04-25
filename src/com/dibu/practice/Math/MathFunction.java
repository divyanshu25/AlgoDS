package com.dibu.practice.Math;

/**
 * Created by divyanshugoyal on 4/25/19.
 */
public class MathFunction {
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }
}
